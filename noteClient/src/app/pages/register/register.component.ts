import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { RegisterUserDto } from 'src/app/model/registerUser';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Notify } from 'notiflix';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit, OnDestroy {
  registrationForm: FormGroup;
  authSubscription !:Subscription;
  constructor(
    private authenticationService: AuthenticationService,
    private router: Router,
  ) {
    this.registrationForm = new FormGroup({
      name: new FormControl(''),
      username: new FormControl(''),
      password: new FormControl(''),
      confirm: new FormControl(''),
      email: new FormControl(''),
    });
  }

  public ngOnInit(): void {}

  public registerUser() {
    const newUser: RegisterUserDto = {
      name: this.registrationForm.get('name')?.value,
      username: this.registrationForm.get('username')?.value,
      password: this.registrationForm.get('password')?.value,
      email: this.registrationForm.get('email')?.value,
    };
    this.authSubscription =  this.authenticationService.registerUser(newUser).subscribe({
      next: (data) => {
        if (data.id != null || data.id != undefined) {
          Notify.success('successfully registered');
          this.router.navigate(['/login']);
        }
      },
      error: (err) => {
        if (err.status === 409) {
          Notify.warning('Username already Exists\nUse a different Username');
        } else {
          Notify.failure(err.message);
        }
      },
    });
  }
  public ngOnDestroy(): void {
    this.authSubscription.unsubscribe();
  }
}
