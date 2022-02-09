import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { fakeDbService } from 'src/app/shared/services/fakeDb';
@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss'],
})
export class HomePageComponent implements OnInit {
  animals;
  constructor(private router: Router, private fakeDb: fakeDbService) {
    this.animals = fakeDb.animals;
  }

  ngOnInit(): void {

  }
}
