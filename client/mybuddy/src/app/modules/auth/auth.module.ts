import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogInPageComponent } from './pages/log-in-page/log-in-page.component';
import { RoutesConfig } from 'src/app/configs/route.config';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { RouterModule, Routes } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';
import { ProfileUpdateComponent } from './pages/profile-update/profile-update.component';

const authRoutes = RoutesConfig.routesNames.auth;


const routes: Routes = [
  { path: authRoutes.logIn, component: LogInPageComponent },
  { path: authRoutes.signUp, component: RegisterPageComponent },
  { path: authRoutes.profileUpdate, component: ProfileUpdateComponent }
];

@NgModule({
  declarations: [
    LogInPageComponent,
    RegisterPageComponent,
    ProfileUpdateComponent
  ],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    SharedModule
  ]
})
export class AuthModule { }
