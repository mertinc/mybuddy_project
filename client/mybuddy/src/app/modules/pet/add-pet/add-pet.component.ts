import { Component, OnInit } from '@angular/core';
import { formatDate } from '@angular/common';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';
import { AuthService } from '../../auth/pages/services/auth.service';
// import { adPublishRequest } from '../../auth/pages/services/axios';

@Component({
  selector: 'app-add-pet',
  templateUrl: './add-pet.component.html',
  styleUrls: ['./add-pet.component.scss'],
})
export class AddPetComponent implements OnInit {
  addPetForm: FormGroup;
  srcResult: any;
  user: any;
  fileName = '';
  formData = new FormData();
  constructor(
    private fb: FormBuilder,
    private apiService: ApiHttpService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.authService.user$.subscribe((data) => {
      this.user = data;
    });
    this.addPetForm = this.fb.group({
      title: ['', Validators.required],
      explanation: ['', [Validators.required]],
      status: ['', [Validators.required]],
      date: ['', [Validators.required]],
    });
    // adPublishRequest()
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
    form.value.userId = this.user[0];
    form.value.phoneNumber = '05538589058';
    // form.value.date = formatDate(form.value.date._d, 'dd/MM/yyyy', 'en-US');
    form.value.date = "2022-02-02";
    console.log(form.value);
    // let headers = new HttpHeaders().set('content-type', 'multipart/form-data')
    this.formData.append('form', form.value);
    // };
    this.apiService.createAdWithImg(this.formData);
  }

  fileUpload(event: any) {
    const file: File = event.target.files[0];
    console.log(file);
    if (file) {
      this.fileName = file.name;
      this.formData.append('file', file);
      console.log(this.formData);
    }
  }
}
