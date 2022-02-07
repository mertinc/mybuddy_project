import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoutesConfig } from './configs/route.config';

const routes: Routes = [
  { path: RoutesConfig.basePaths.auth, loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule) },
  // { path: RoutesConfig.basePaths.user, loadChildren: () => import('./modules/')) },
  // { path: '**', redirectTo: RoutesConfig.routes.error404 }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
