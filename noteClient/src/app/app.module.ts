import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AddNoteComponent } from './pages/add-note/add-note.component';
import { ListAllComponent } from './pages/list-all/list-all.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { OverviewComponent } from './pages/overview/overview.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { QuillModule } from 'ngx-quill';
import { SearchPipe } from './pipes/search.pipe';
import { HttpClientModule } from '@angular/common/http';
import { ViewNoteComponent } from './pages/view-note/view-note.component';
@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    AddNoteComponent,
    ListAllComponent,
    ProfileComponent,
    OverviewComponent,
    SearchPipe,
    ViewNoteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    QuillModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
