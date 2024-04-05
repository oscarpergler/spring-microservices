#! /bin/bash

# decide how many times to iterate the following code:

# curl to localhost:8080/posts/actuator/health/liveness to see if the post service is ready for traffic

# if it is ready for traffic, collect logs and append them to a local text file:
# docker logs [container_name] | findstr "process runnig forn" > log.txt

# docker restart [container_name]