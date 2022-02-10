import { NgModule } from '@angular/core';
import { MaterialModule } from './modules/material.module';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { fakeDbService } from './services/fakeDb';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    RouterModule,
    HttpClientModule,
  ],
  declarations: [],
  exports: [CommonModule, MaterialModule, ReactiveFormsModule],
  providers: [fakeDbService],
})
export class SharedModule {}
