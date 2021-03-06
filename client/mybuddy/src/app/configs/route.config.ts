import { InjectionToken } from '@angular/core';

export const ROUTES_CONFIG = new InjectionToken('routes.config');

const basePaths = {
  pet: 'pet',
  auth: 'auth',
};

const routesNames = {
  home: '',
  error404: '404',
  pet: {
    addPet: 'add-pet',
    myPet: 'my-pet',
    detail: ':id',
  },
  auth: {
    signUp: 'sign-up',
    logIn: 'log-in',
    profileUpdate: 'profile-update'
  }
};

export const RoutesConfig: any = {
  basePaths,
  routesNames,
  routes: {
    home: `/${routesNames.home}`,
    error404: `/${routesNames.error404}`,
    pet: {
      myPet: `/${basePaths.pet}/${routesNames.pet.myPet}`,
      addPet: `/${basePaths.pet}/${routesNames.pet.addPet}`,
      detail: `/${basePaths.pet}/${routesNames.pet.detail}`
    },
    auth: {
      signUp: `/${basePaths.auth}/${routesNames.auth.signUp}`,
      logIn: `/${basePaths.auth}/${routesNames.auth.logIn}`,
      profileUpdate: `/${basePaths.auth}/${routesNames.auth.profileUpdate}`,
    }
  }
};
