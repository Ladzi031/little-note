import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css'],
})
export class NavBarComponent implements OnInit, OnDestroy {
  isUserLoggedIn!: boolean;
  authenticationSub!: Subscription;

  constructor(
    private authentication: AuthenticationService,
    private router: Router,
  ) {}

  public ngOnInit(): void {
    this.authenticationSub = this.authentication.subjectLoggedIn.subscribe(
      (state: boolean) => {
        this.isUserLoggedIn = state;
      },
    );
  }

  public ngOnDestroy(): void {
    this.authenticationSub.unsubscribe();
  }

  public logout() {
    this.authentication.logout();
    this.router.navigate(['']);
  }
  public login() {
    this.router.navigate(['/login']);
  }
}
