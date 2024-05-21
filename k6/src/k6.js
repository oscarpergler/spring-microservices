import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 1,
    duration: '100s',
};

/*
 Through gateway: http://gateway:8080/posts
 Directly to service: http://posts:8081/posts
*/
export default function () {
    http.get('http://posts:8081/posts');
    sleep(1);
}

/**
 You must first pull the k6 image: docker pull grafana/k6

 adjust the directory as needed:

 docker run --rm --network=microservices -v C:/Users/oscar/Documents/GitHub/spring-microservices/k6/src:/src -i grafana/k6 run /src/k6.js
 **/