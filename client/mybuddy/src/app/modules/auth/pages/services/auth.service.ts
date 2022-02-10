// Angular Modules
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
// import { AngularFireAuth } from '@angular/fire/auth';
// import {
//   AngularFirestore,
//   AngularFirestoreDocument,
// } from '@angular/fire/firestore/';
@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private userData = new BehaviorSubject<any>([]);
  readonly user$ = this.userData.asObservable();
  constructor(
    // Angular Modules
    private http: HttpClient,
    // private afs: AngularFirestore,
    // private afAuth: AngularFireAuth
  ) {
  //   this.afAuth.authState.subscribe((user) => {
  //     if (user) {
  //       this.userData.next(user);
  //     }
  //   });
  // }

  // signIn(email, password) {}

  // signUp(email: string, password: string) {
  //   return this.afAuth
  //     .createUserWithEmailAndPassword(email, password)
  //     .then((result) => {
  //       this.setUserData(result.user);
  //     });
  // }

  // setUserData(user: any) {
  //   const userRef: AngularFirestoreDocument<any> = this.afs.doc(
  //     `users/${user.uid}`
  //   );
  //   const userData = {
  //     uid: user.uid,
  //     email: user.email,
  //     displayName: user.displayName,
  //     photoURL: user.photoURL,
  //     emailVerified: user.emailVerified,
  //   };
  //   return userRef.set(userData, {
  //     merge: true,
  //   });
  // }

  // signOut() {
  //   return this.afAuth.signOut().then(() => {
  //     this.userData.next(null);
  //   });
  }

  getUser(){
    this.user$.subscribe(data => {
      return console.log(data);
    })
  }
}
