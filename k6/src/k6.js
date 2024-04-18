import http from 'k6/http';
import { sleep } from 'k6';
export const options = {
  vus: 100,
  duration: '60s',
};
export default function () {
  http.get('http://gateway:8080/posts/all');
  sleep(1);
}

// docker run --rm --network=microservices -v C:/Users/oscar/Documents/exjobb/compiled-javaservices/k6/src:/src -i grafana/k6 run /src/k6.js