## System overview
![5b(1)](https://github.com/oscarpergler/spring-microservices/assets/70218472/391c0050-35a5-426f-8e38-2204c93a292f)

## How to run:

Select which version you wish to test, main/aot branch

Build all services and their docker images: ```./build.sh``` (note that AOT services may take up to 15 minutes to compile depending on your hardware)

then run the built services with: ```docker compose up``` (you must have docker installed and running)

run cold start test: ```./logging.sh <container_name>```

## Future work
* Social graph service to pair with timeline, as of right now it does not make much more sense than simply having a getAllPosts filtered on users
* Better error and exception handling
* A frontend

## These containers must be run for the system to work
(Ignore this if you are using docker-compose)
### redis temp container: 

``docker run -d -p 6379:6379 redislabs/redismod``

Redis config source: https://www.baeldung.com/spring-data-redis-tutorial

### rabbitmq temp container: 

```docker run -d -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management```

### consul temp container:

```docker run -d --name=consul-dev -p 8500:8500 consul:1.7.2 agent -node=microservices -dev```
