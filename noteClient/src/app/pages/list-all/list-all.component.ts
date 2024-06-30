import { Component } from '@angular/core';

@Component({
  selector: 'app-list-all',
  templateUrl: './list-all.component.html',
  styleUrls: ['./list-all.component.css']
})
export class ListAllComponent {
  users: any[] = [1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 22, 2, 2];
}
