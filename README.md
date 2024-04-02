## Currently developing without docker:

* user
* post
* timeline

*all services will eventually be containerized*

## Services that must be run in containers:

### redis temp container: 

``docker run -d -p 6379:6379 redislabs/redismod``

Redis config source: https://www.baeldung.com/spring-data-redis-tutorial

### rabbitmq temp container: 

```docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management```

