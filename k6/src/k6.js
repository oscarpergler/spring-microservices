import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    vus: 1,
    duration: '2000s',
};

/*
 Through gateway: http://localhost:8080/posts
 Directly to service: http://localhost:8081/posts
*/
export default function () {
    http.get('http://localhost:8081/posts');
    sleep(1);
}

// install k6 -->
// run: k6 run k6.js --out csv=[name of file]].csv