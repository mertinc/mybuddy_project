import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddPetComponent } from './add-pet/add-pet.component';
import { RouterModule, Routes } from '@angular/router';
import { RoutesConfig } from 'src/app/configs/route.config';
import { SharedModule } from 'src/app/shared/shared.module';
import { PetDetailComponent } from './pet-detail/pet-detail.component';
import { UserGuard } from '../auth/pages/services/user.guard';

const petRoutes = RoutesConfig.routesNames.pet;

const routes: Routes = [
  {
    path: petRoutes.addPet,
    component: AddPetComponent,
    canActivate: [UserGuard],
  },
  { path: petRoutes.detail, component: PetDetailComponent },
];

@NgModule({
  declarations: [AddPetComponent, PetDetailComponent],
  imports: [CommonModule, SharedModule, RouterModule.forChild(routes)],
})
export class PetModule {}
