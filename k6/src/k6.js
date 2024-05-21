import http from 'k6/http';

export const options = {
    vus: 50, // 50 virtual users
    duration: '100s', // sums up to about 5000 requests
};

/*
 Through gateway: http://gateway:8080/posts
 Directly to service: http://posts:8081/posts
*/
export default function () {
    http.get('http://posts:8081/posts');
}

/**
 You must first pull the k6 image: docker pull grafana/k6

 adjust the directory as needed:

 docker run --rm --network=microservices -v C:/Users/oscar/Documents/GitHub/spring-microservices/k6/src:/src -i grafana/k6 run /src/k6.js
 **/