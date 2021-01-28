import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { ILogin } from '../interfaces/login.interface';
const httpOptions =  {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),

}

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginUrl = 'http://localhost:8080/login';
  openLoginModal = new Subject<boolean>();
  constructor(
    private http: HttpClient
  ) { }

  signIn(loginData: ILogin): void{
    this.http.post(this.loginUrl, loginData, httpOptions)
     
    .subscribe(() => {
      console.log('hello');
    });
  }
}
