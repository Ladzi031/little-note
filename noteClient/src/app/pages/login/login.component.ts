import { Component } from '@angular/core';
import { Notify } from 'notiflix';
import { User } from '../../model/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  loginForm: FormGroup;

  constructor(
    private authenticationService: AuthenticationService,
    private router: Router,
  ) {
    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl(''),
    });
  }
  public login() {
    // TODO LATER implement proper Validators...
    if (
      !this.loginForm.get('username')?.valid ||
      !this.loginForm.get('password')?.valid
    ) {
      Notify.failure('Please enter your login Details');
    } else {
      const user: User = {
        username: this.loginForm.get('username')?.value,
        password: this.loginForm.get('password')?.value,
      };
      this.authenticationService.login(user).subscribe({
        next: (data) => {
          if (data.isLoggedIn) {
            this.router.navigate(['/dashboard']);
          } else {
            Notify.failure('Incorrect Username or password');
          }
        },
        error: (err) => {
          Notify.failure(err.message);
        },
      });
    }
  }

  public forgot() {
    Notify.info("That feature hasn't yet been implemented");
  }
}
