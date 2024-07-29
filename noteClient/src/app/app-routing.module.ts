import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AddNoteComponent } from './pages/add-note/add-note.component';
import { ListAllComponent } from './pages/list-all/list-all.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { OverviewComponent } from './pages/overview/overview.component';
import { ViewNoteComponent } from './pages/view-note/view-note.component';
import { authGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', redirectTo: '', pathMatch: 'full' },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [authGuard],
    canActivateChild: [authGuard],
    children: [
      { path: 'add', component: AddNoteComponent },
      { path: 'list', component: ListAllComponent },
      { path: 'view/:noteId', component: ViewNoteComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'overview', component: OverviewComponent },
      { path: '**', redirectTo: 'add', pathMatch: 'full' },
    ],
  },
  { path: '**', redirectTo: '', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
