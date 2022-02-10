import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthService } from 'src/app/modules/auth/pages/services/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit, OnDestroy {
  isUser: boolean = false;
  sub: Subscription;
  constructor(private authService: AuthService, private route:Router) {}

  ngOnInit(): void {
    console.log(this.authService.getUser());

    this.authService.user$.subscribe((user) => {
      console.log('user');
      console.log(user);
      if (user && user.length > 0) {
        this.isUser = user;
      } else {
        this.isUser = false;
      }
    });
    // console.log(this.isUser);
    // console.log(this.authService.getUser());
  }

  signOut(): void {
    this.authService.signOut();
    this.route.navigateByUrl('/');
  }
  ngOnDestroy(): void {
    // if (this.sub) {
    //   this.sub.unsubscribe();
    // }
  }
}
