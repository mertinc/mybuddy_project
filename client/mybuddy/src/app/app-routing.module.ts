import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoutesConfig } from './configs/route.config';

const routes: Routes = [
  { path: RoutesConfig.basePaths.auth, loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule) },
  { path: RoutesConfig.basePaths.pet, loadChildren: () => import('./modules/pet/pet.module').then(m => m.PetModule) },
  { path: '**', redirectTo: '/', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
