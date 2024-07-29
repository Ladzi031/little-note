import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Notify } from 'notiflix';
import { UserProfileDto } from 'src/app/model/user';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UsersService } from 'src/app/services/users.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  shouldDisplayUpdateSection: boolean = false;
  updateAttribute!: string;
  userProfile!: UserProfileDto;
  value!: string;
  constructor(
    private router: Router,
    private usersService: UsersService,
    private authenticationService: AuthenticationService,
  ) {}
  public ngOnInit(): void {
    const id = this.authenticationService.getUserId();
    if (id != null || id != undefined) {
      this.usersService.getUserProfile(id).subscribe({
        next: (data) => {
          this.userProfile = data;
          this.userProfile.password = '*'.repeat(8);
        },
        error: (err) => {
          Notify.failure('something went wrong!');
          Notify.failure(err.message);
        },
      });
    } else {
      this.routeUser();
    }
  }
  public display() {
    this.shouldDisplayUpdateSection = true;
  }
  public update() {
    this.shouldDisplayUpdateSection = false;
    const id = this.authenticationService.getUserId();
    if (id != null || id != undefined) {
      if (
        ((this.updateAttribute != null || this.updateAttribute != undefined) &&
          this.value != null) ||
        this.value != undefined
      ) {
        this.usersService
          .updateDetails(this.updateAttribute, this.value, id)
          .subscribe({
            next: (data) => {
              this.userProfile = data;
              this.userProfile.password = '*'.repeat(8);
              Notify.success('information successfully updated');
            },
            error: (err) => {
              Notify.failure('Something went wrong');
              Notify.failure(err.message);
            },
          });
      }
    } else {
      this.routeUser();
    }
  }

  public deleteProfile() {
    if (
      confirm(
        'Are you sure you want to delete your profile?\n all your notes will be deleted too',
      )
    ) {
      const id = this.authenticationService.getUserId();
      if (id != null || id != undefined) {
        this.usersService.deleteProfile(id).subscribe({
          next: (data) => {
            Notify.info('account deleted sucessfully');
            this.authenticationService.logout(); // discards current id in the client-side
            this.router.navigate(['/login']);
          },
          error: (err) => {
            Notify.failure('something went wrong');
            Notify.failure(err.msg);
          },
        });
      }
    }
  }
  private routeUser() {
    Notify.failure('Please Login');
    this.router.navigate(['/login']);
  }
}
