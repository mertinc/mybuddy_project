import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.scss']
})
export class LogInPageComponent implements OnInit {

  constructor(private apiService:ApiHttpService, private fb: FormBuilder, private authService:AuthService) { }
  loginForm: FormGroup;
  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  login(formData: FormGroup){
    console.log(formData.value);

    this.apiService.login(formData.value).then((data) => {
      console.log(data);
      if(data === true) {
        this.authService.user$.subscribe(value => {
          value = ;
          console.log(value);
        })
      }
    }).catch((e) => {
      console.log(e);
    })
  }

}
