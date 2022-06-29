import { Injectable } from "@angular/core";
import { AngularFireAuth } from "@angular/fire/compat/auth";
import firebase from "firebase/compat";

@Injectable({
  providedIn: "root"
})
export class LoginService {
  messages: string[] = [];

  add(message: string) {
    this.messages.push(message);
  }

  clear() {
    this.messages = [];
  }
  constructor(private_auth : AngularFireAuth){}
}