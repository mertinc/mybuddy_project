// Angular Modules
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class ApiHttpService {
  private readonly url = 'http://localhost:8088/mybuddy_project';
  constructor(
    // Angular Modules
    private http: HttpClient
  ) {}

  getAd(): Observable<any> {
    return this.http.get(this.url + '/ads/findAll');
  }

  login(data: any){
    return new Promise((resolve, reject) => {
      this.http
        .post(this.url + '/users/loginUser', data)
        .toPromise()
        .then(
          (res) => {
            resolve(res);
          },
          (msg) => {
            reject(msg);
          }
        );
    });
  }

  getAdWithId(id: string) {
    return new Promise((resolve, reject) => {
      this.http
        .get(this.url + `/ads/${id}`)
        .toPromise()
        .then(
          (res) => {
            resolve(res);
          },
          (msg) => {
            reject(msg);
          }
        );
    });
  }

  createAd(body: any) {
    return new Promise((resolve, reject) => {
      this.http
        .post(this.url + '/ads/createAd', body)
        .toPromise()
        .then(
          (res) => {
            resolve(res);
          },
          (msg) => {
            reject(msg);
          }
        );
    });
  }

  createAdWithImg(body: any) {
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'multipart/form-data');
    return new Promise((resolve, reject) => {
      this.http
        .post(this.url + '/ads/', body,{headers:headers})
        .toPromise()
        .then(
          (res) => {
            resolve(res);
          },
          (msg) => {
            reject(msg);
          }
        );
    });
  }

  createUser(body: any) {
    return new Promise((resolve, reject) => {
      this.http
        .post(this.url + '/users/addUser', body)
        .toPromise()
        .then(
          (res) => {
            resolve(res);
          },
          (msg) => {
            reject(msg);
          }
        );
    });
  }
}
