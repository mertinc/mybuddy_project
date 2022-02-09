import { NgModule } from '@angular/core';
import { MaterialModule } from './modules/material.module';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { fakeDbService } from './services/fakeDb';
@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    RouterModule
  ],
  declarations: [

  ],
  exports: [
    CommonModule,
    MaterialModule
  ],
  providers:[fakeDbService]
})

export class SharedModule {
}
