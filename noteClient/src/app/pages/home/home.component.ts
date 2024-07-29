import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent {
  isUserLoggedIn: boolean;
  constructor(
    private router: Router,
    private authentication: AuthenticationService,
  ) {
    this.isUserLoggedIn = this.authentication.isLoggedIn();
  }
  public login() {
    this.router.navigate(['/login']);
  }
  public register() {
    this.router.navigate(['/register']);
  }
}
