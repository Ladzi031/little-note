import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { UserProfileDto } from '../model/user';
import { USERS_URL } from '../config/api';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  constructor(private http: HttpClient) {}

  public getUserProfile(id: number): Observable<UserProfileDto> {
    return this.http.get<UserProfileDto>(`${USERS_URL}/${id}`).pipe(
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }

  public updateDetails(
    attr: string,
    value: string,
    id: number,
  ): Observable<UserProfileDto> {
    const payload = {
      id: id,
      newValue: value,
      attribute: attr,
    };
    return this.http.put<UserProfileDto>(USERS_URL, payload).pipe(
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }

  public deleteProfile(id: number) {
    return this.http.delete(`${USERS_URL}/${id}`).pipe(
      catchError((err) => {
        return throwError(() => err);
      }),
    );
  }
}
