import { Component, OnInit } from '@angular/core';
import {UserService} from '../../_services/user.service';
import {Role, User} from '../../_services/ticket.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  public parentId = "";
  currentUser: User;
  isAdmin: boolean;
  isUser: boolean;


  clickedMenu(event) {
    var target = event.currentTarget;
    let parentId = target.id;
    if (parentId == this.parentId) {
      this.parentId = "";
    } else {
      this.parentId = target.id;
    }
  }
  constructor(private userService: UserService) { }

  checkAdmin(roles: Role[]){
    if(roles){
      this.isAdmin=true;
      this.isUser=false;
    }else{
      this.isAdmin=false;
      this.isUser=true;
      console.log('else');
    }
  }

  ngOnInit() {
    this.currentUser = this.userService.getCurrentUser();
    const body = document.querySelector('body');
    this.checkAdmin(this.currentUser.roles);
    // add class 'hover-open' to sidebar navitem while hover in sidebar-icon-only menu
    document.querySelectorAll('.sidebar .nav-item').forEach(function (el) {
      el.addEventListener('mouseover', function() {
        if(body.classList.contains('sidebar-icon-only')) {
          el.classList.add('hover-open');
        }
      });
      el.addEventListener('mouseout', function() {
        if(body.classList.contains('sidebar-icon-only')) {
          el.classList.remove('hover-open');
        }
      });
    });
  }

}
