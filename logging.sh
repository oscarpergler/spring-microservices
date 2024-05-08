#! /bin/bash

if [ $# -ne 1 ]; then
    echo "Usage: $0 <container_name>"
    exit 1
fi

ITERATIONS=200

CONTAINER_NAME="$1"

LOG_FILE="./test/$CONTAINER_NAME.txt"
LOAD_LOG_FILE="./test/$CONTAINER_NAME-cpu-load.txt"

touch "$LOG_FILE"
touch "$LOAD_LOG_FILE"

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

    # Check service liveness
    response=$(curl -s -o /dev/null -w "%{http_code}" $SERVICE_ENDPOINT)

    while [ $response -ne 200 ]; do
      echo "$CONTAINER_NAME-service is not ready. $response"
      sleep 1
      response=$(curl -s -o /dev/null -w "%{http_code}" $SERVICE_ENDPOINT)
    done

    if [ $response -eq 200 ]; then
        echo "Service is ready. Collecting logs..."

        # Collect logs
        docker logs $CONTAINER_NAME | grep "process running for" >> $LOG_FILE

        echo "Logs collected."

        echo "Restarting container $CONTAINER_NAME..."
        docker-compose stop "$CONTAINER_NAME"
        docker-compose rm -f "$CONTAINER_NAME"

        sleep 5

        # Start a new container from the same image and attach it to the Docker Compose network
        docker-compose up -d "$CONTAINER_NAME"

        timestamp=$(date +"%Y-%m-%d %H:%M:%S")
        cpu_load=$(top -bn1 | grep "Cpu(s)" | awk '{print $2}')
        echo "$timestamp CPU Load: $cpu_load%" >> "$LOAD_LOG_FILE"
    fi

    sleep 5
done

echo "Script completed"
