import http from 'k6/http';
import { sleep } from 'k6';
export const options = {
  vus: 100, // 100 virtual users
  duration: '60s', // about 6000 requests
};
export default function () {
  http.get('http://gateway:8080/posts/all');
  sleep(1);
}

/**
 You must first pull the k6 image: docker pull grafana/k6
 Then run the following command to run the test:

 docker run --rm --network=microservices -v C:/Users/oscar/Documents/exjobb/compiled-javaservices/k6/src:/src -i grafana/k6 run /src/k6.js
 **/