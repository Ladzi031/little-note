import { Component } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  shouldDisplayUpdateSection: boolean = false;
  updateAttribute: string = "";
  public display() {
    this.shouldDisplayUpdateSection = true;
  }

  public update() {
    this.shouldDisplayUpdateSection = false;
    
  }

  public changed() {
  }
}
