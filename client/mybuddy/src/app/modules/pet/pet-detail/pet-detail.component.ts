import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';

@Component({
  selector: 'app-pet-detail',
  templateUrl: './pet-detail.component.html',
  styleUrls: ['./pet-detail.component.scss'],
})
export class PetDetailComponent implements OnInit {
  adId: any;
  addDetail: any;
  comments: any;
  constructor(
    private route: ActivatedRoute,
    private apiService: ApiHttpService
  ) {}

  ngOnInit(): void {
    this.adId = this.route.snapshot.paramMap.get('id');
    this.getAdDetail();
  }

  getAdDetail(): void {
    this.apiService.getAdWithId(this.adId).then((data: any) => {
      this.addDetail = [data];
      this.comments = data.comments;
    });
  }
}
