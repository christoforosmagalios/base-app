import { Component, OnInit } from '@angular/core';
import { PageDTO } from '../../dto/page-dto';
import { UserDTO } from '../../dto/user-dto';
import { UserService } from '../user.service';

@Component({
  selector: 'app-list-users',
  templateUrl: './list-users.component.html',
  styleUrls: ['./list-users.component.css']
})
export class ListUsersComponent implements OnInit {

  // The list of users.
  users = [];
  // Active page.
  page = 1;
  // Total number of users in the Database.
  collectionSize: number;
  // Users per page.
  size: number = 10;

  constructor(private userService: UserService) { }

  ngOnInit() {
    // Find all users in order to display them.
    this.findAll();
  }

  /**
   * Find all the users.
   */
  findAll() {
    this.userService.findAll(this.size, (this.page - 1), "createdOn", "desc")
    .subscribe((page: PageDTO<UserDTO>) => {
      this.users = page.content;
      this.collectionSize = page.totalElements;
    });
  }

}
