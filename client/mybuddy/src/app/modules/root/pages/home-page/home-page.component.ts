import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ad } from 'src/app/shared/models/ad.model';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';
import { fakeDbService } from 'src/app/shared/services/fakeDb';
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent implements OnInit {
  animals: any;
  constructor(
    private router: Router,
    private fakeDb: fakeDbService,
    private apiService: ApiHttpService
  ) {
    // this.animals = fakeDb.animals;
  }

  ngOnInit(): void {
    this.getAdd();
    // this.apiService.createAd(this.test);
  }

  getAdd(): void {
    this.apiService.getAd().subscribe((data: Ad) => {
      this.animals = data;
      console.log(this.animals);

    });
  }
}
