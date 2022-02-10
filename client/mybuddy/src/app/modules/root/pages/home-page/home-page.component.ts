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
  test =
  {
    "userId":"9fe35a63-5be0-4f4b-abbd-5b436646bb4e",
    "date": "2022-4-1-2-12-1",
    "title":"Buunu sahiplen",
    "explanation" : "Bu bir 5555",
    "image" : "resim olacak ",
    "phoneNumber" : "010101010222",
    "status": "active"
    }
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
    this.apiService.getAdd().subscribe((data: Ad) => {
      this.animals = data;
      console.log(data);

    });
  }
}
