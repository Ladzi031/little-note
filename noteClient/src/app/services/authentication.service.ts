import { Injectable, OnInit } from '@angular/core';
import { User } from '../model/user';
import { LOGIN_URL, REGISTER_URL } from '../config/api';
import { HttpClient } from '@angular/common/http';
import { LoginDto } from '../model/login';
import { catchError, first, Observable, Subject, tap, throwError } from 'rxjs';
import { RegisterUserDto } from '../model/registerUser';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService implements OnInit {
  private isUserLoggedIn: boolean = false;
  private userId: number | null | undefined = null;

  public subjectLoggedIn = new Subject<boolean>();
  public subjectUserId = new Subject<number | null | undefined>();
  constructor(private http: HttpClient) {}

  public ngOnInit(): void {
    this.subjectLoggedIn.next(this.isUserLoggedIn);
    this.subjectUserId.next(null);
  }

  public isLoggedIn() {
    return this.isUserLoggedIn;
  }
  public getUserId() {
    return this.userId;
  }

  public logout() {
    this.subjectLoggedIn.next(false);
  }

  public login(user: User): Observable<LoginDto> {
    const payload = {
      username: user.username,
      password: user.password,
    };

    return this.http.post<LoginDto>(LOGIN_URL, payload).pipe(
      first(),
      tap((loginDto) => {
        this.userId = loginDto?.id;
        this.isUserLoggedIn = loginDto.isLoggedIn;
        this.subjectLoggedIn.next(this.isUserLoggedIn);
        this.subjectUserId.next(this.userId);
      }),
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }

  public registerUser(newUser: RegisterUserDto): Observable<RegisterUserDto> {
    const payload = {
      username: newUser.username,
      name: newUser.name,
      email: newUser.email,
      password: newUser.password,
    };
    return this.http.post<RegisterUserDto>(REGISTER_URL, payload).pipe(
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }
}
