import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.scss'],
})
export class LogInPageComponent implements OnInit {
  constructor(
    private apiService: ApiHttpService,
    private fb: FormBuilder,
    private authService: AuthService,
    private route: Router
  ) {}
  loginForm: FormGroup;
  user: any;
  ngOnInit(): void {
    console.log("this.authService.getUser()");
    console.log(this.authService.getUser());

    this.authService.user$.subscribe((user) => {
      this.user = user;
    });
    this.loginForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  signIn(formData: FormGroup) {
    console.log(formData.value);

    this.apiService
      .login(formData.value)
      .then((data) => {
        console.log(data);
        if (data !== null) {
          this.authService.sendUser(data);
          this.route.navigateByUrl('/');
        }
      })
      .catch((e) => {
        console.log(e);
      });
  }
}
