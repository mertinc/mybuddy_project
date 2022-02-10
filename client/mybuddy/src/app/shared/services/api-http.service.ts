// Angular Modules
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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

  getAdd(): Observable<any> {
    return this.http.get(this.url + '/ads/findAll');
  }

  createAd(body: any) {
    return new Promise((resolve, reject) => {
      this.http
        .post(this.url + '/ads/addAd', body)
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
