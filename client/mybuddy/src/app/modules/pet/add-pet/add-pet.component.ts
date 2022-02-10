import { Component, OnInit } from '@angular/core';
import { formatDate } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.scss'],
})
export class AddPetComponent implements OnInit {
  addPetForm: FormGroup;
  srcResult: any;
  constructor(private fb: FormBuilder, private apiService: ApiHttpService) {}

  ngOnInit(): void {
    this.addPetForm = this.fb.group({
      title: ['', Validators.required],
      explanation: ['', [Validators.required]],
      status: ['', [Validators.required]],
      date: ['', [Validators.required]],
    });
  }

  onSubmit(form: FormGroup) {
    console.log('Valid?', form.valid); // true or false
    console.log('title', form.value.title);
    console.log('explanation', form.value.explanation);
    console.log('status', form.value.status);
    console.log('date', form.value.date);
    console.log('date', form.value.date._d);
    console.log('date', formatDate(form.value.date._d, 'dd/MM/yyyy', 'en-US'));
    console.log('date', form.value.date._i);
    // const data = {
    //   "title": form.value.title,
    //   "date": formatDate(form.value.date._d, 'dd/MM/yyyy', 'en-US'),
    //   "explanation": form.value.explanation,

    // };
    // this.apiService.createAd();
  }

  fileUpload(data: any) {
    console.log(data);
  }
}
