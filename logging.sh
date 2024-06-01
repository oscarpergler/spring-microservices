#! /bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: $0 <container_name>"
    exit 1
fi

ITERATIONS=1000

CONTAINER_NAME="$1"

LOG_FILE="./data/final/$CONTAINER_NAME.txt"
CPU_LOG="./data/final/$CONTAINER_NAME-cpu.txt"

touch "$LOG_FILE"
touch "$CPU_LOG"

case "$CONTAINER_NAME" in
    "posts")
        echo "Posts-service is mapped to localhost:8081"
        PORT=8081
        ;;
    "timeline")
        echo "Posts-service is mapped to localhost:8082"
        PORT=8082
        ;;
    "users")
        echo "Posts-service is mapped to localhost:8083"
        PORT=8083
        ;;
    *)
        echo "$CONTAINER_NAME is not a valid container"
        exit
        ;;
esac

SERVICE_ENDPOINT="http://localhost:$PORT/actuator/health/liveness"

for ((i=1; i<=$ITERATIONS; i++))
do
    echo "************ $CONTAINER_NAME: Iteration $i ************"

    response=$(curl -s -o /dev/null -w "%{http_code}" $SERVICE_ENDPOINT)

    while [ $response -ne 200 ]; do
      echo "$CONTAINER_NAME-service is not ready. $response"
      sleep 1
      response=$(curl -s -o /dev/null -w "%{http_code}" $SERVICE_ENDPOINT)
    done

    if [ $response -eq 200 ]; then
        echo "Service is ready. Collecting logs..."

        # to save myself from future cardiac arrest: This grabs the console line containing the start time as well... Not just "process running for"
        docker logs "$CONTAINER_NAME" | grep "process running for" >> "$LOG_FILE"

        echo "Logs collected."

        echo "Restarting container $CONTAINER_NAME..."
        docker-compose stop "$CONTAINER_NAME"
        docker-compose rm -f "$CONTAINER_NAME"

        sleep 2

        # start a new container from the same image and attach it to the Docker Compose network
        docker-compose up -d "$CONTAINER_NAME"

        # collect 3 CPU logs right after a cold start
        for ((k=1; k<=3; k++))
        do
          echo "$k: Logging CPU..."
          docker stats "$CONTAINER_NAME" --format "{{.CPUPerc}}" --no-stream >> "$CPU_LOG"
        done
    fi
done

echo "Script completed"
