// npm install form-data
// npm install axios

import axios, {Axios, AxiosRequestConfig} from 'axios'
import * as fs from "fs";
import * as FormData from "form-data"



export function adPublishRequest() {
    const data = new FormData();
    data.append('form', '{ "userId":"2862d4d7-26ef-4858-9162-b7bc33ab37c1",    "title":"kedi",    "date":"2022-02-10",    "explanation":"merhaba",    "phoneNumber":"9349928029",  "status":"aktif"}', {contentType: 'application/json'});
    fs.createReadStream("C:\Users\FURKAN\Desktop\fotoğraflar\naz.jpg");

    const config: AxiosRequestConfig = {
        method: 'post',
        url: 'http://localhost:8088/mybuddy_project/ads/',
        headers: { ...data.getHeaders() },
        data : data
      };
   axios(config)
      .then(function (response) {
        console.log(JSON.stringify(response.data));
      })
      .catch(function (error) {
        console.log(error);
      });
}
