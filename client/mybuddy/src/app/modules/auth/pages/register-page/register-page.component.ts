import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiHttpService } from 'src/app/shared/services/api-http.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss'],
})
export class RegisterPageComponent implements OnInit {
  registerForm: FormGroup;
  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private apiService: ApiHttpService
  ) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      userName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      phoneNumber: ['',Validators.required],
    });
  }

  onSubmit(form: FormGroup) {
    console.log(form.value);

    this.apiService
      .createUser(form.value)
      .then(() => {
        //toastr eklencek
      })
      .catch((e) => {
        console.log(e);
      });
    // this.authService.signUp(form.value.emailAddress,form.value.password).then((data) => {
    //   console.log("kayıt başarılı" + data)
    //   console.log(form.value)
    // })
  }
}
