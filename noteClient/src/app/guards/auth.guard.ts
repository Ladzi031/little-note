import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';
import { Notify } from 'notiflix';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router)
  if (inject(AuthenticationService).isLoggedIn()) {
    return true;
  } else {
    router.navigate(["/login"]);
    Notify.info("Please Login");
    return false;
  }
};
