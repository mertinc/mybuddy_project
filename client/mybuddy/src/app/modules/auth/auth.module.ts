import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LogInPageComponent } from './pages/log-in-page/log-in-page.component';
import { RoutesConfig } from 'src/app/configs/route.config';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { RouterModule, Routes } from '@angular/router';
import { SharedModule } from 'src/app/shared/shared.module';

const authRoutes = RoutesConfig.routesNames.auth;


const routes: Routes = [
  { path: authRoutes.logIn, component: LogInPageComponent },
  { path: authRoutes.signUp, component: RegisterPageComponent }
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    SharedModule
  ]
})
export class AuthModule { }
