import { Component, OnInit, Output } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../shared/services/login.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.scss']
})
export class SignInComponent implements OnInit {
  signIn!: FormGroup;
  constructor(
    private router: Router,
    private loginService: LoginService
  ) { }

  ngOnInit(): void {
    this.signIn = new FormGroup({
      userName: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    });
  }
  public login(): void {
    console.log(this.signIn.value);
    if (this.signIn.valid) {
      this.loginService.signIn(this.signIn.value);
    }
    this.signIn.reset();
    this.loginService.openLoginModal.next(false);
    this.router.navigateByUrl('admin');
  }

  public closeModal(event: any): void {
    if (event.target.classList.value === 'shadow-wrapper') {
      this.loginService.openLoginModal.next(false);
    }
  }
}
