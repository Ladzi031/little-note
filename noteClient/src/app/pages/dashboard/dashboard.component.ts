import { Component, OnInit } from '@angular/core';
import { Notify } from 'notiflix';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  constructor() { }
  public ngOnInit(): void {
    Notify.success("smh, we up!");
  }
}
