import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogInPageComponent } from './modules/auth/pages/log-in-page/log-in-page.component';
import { RegisterPageComponent } from './modules/auth/pages/register-page/register-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LogInPageComponent,
    RegisterPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
