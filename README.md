## How to run:

Build all services and their docker images: ```./build.sh```

then run the built services with: ```docker compose up```

## These containers must be run for the system to work
(Ignore this if you are using docker-compose)
### redis temp container: 

``docker run -d -p 6379:6379 redislabs/redismod``

Redis config source: https://www.baeldung.com/spring-data-redis-tutorial

### rabbitmq temp container: 

```docker run -d -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management```

### consul temp container:

```docker run -d --name=consul-dev -p 8500:8500 consul:1.7.2 agent -node=microservices -dev```

