import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { ILogin } from '../interfaces/login.interface';
import { tap } from 'rxjs/operators';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  loginUrl = 'http://localhost:8080/login';
  openLoginModal = new Subject<boolean>();

  get token(): string {
    const expDate = new Date(localStorage.getItem('expDate') || '');
    if (new Date() > expDate) {
      this.logout();
      return '';
    }
    return localStorage.getItem('token') || '';
  }

  constructor(private http: HttpClient) {}

  signIn(loginData: ILogin): void {
    this.http
      .post(this.loginUrl, loginData, httpOptions)
      .pipe(tap(this.setToken));
  }

  logout(): void {
    this.setToken(null);
  }

  isAuthenticated(): boolean {
    return !!this.token;
  }

  private setToken(response: any): void {
    if (response) {
      console.log(response);
      const expDate = new Date(new Date().getTime() + 36000000);
      localStorage.setItem('token', response.token);
      localStorage.setItem('expDate', JSON.stringify(expDate));
    } else {
      localStorage.clear();
      // change this later
    }
  }
}
