import { Component, OnInit } from '@angular/core';
import { PageDTO } from '../../dto/page-dto';
import { UserDTO } from '../../dto/user-dto';
import { LoaderService } from '../../shared/components/loader/loader.service';
import { Messages } from '../../shared/constants/messages';
import { UtilsService } from '../../shared/services/utils.service';
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
  collectionSize: number = 0;
  // Users per page.
  size: number = 10;
  // The sort options to be used in pagination.
  sort = {
    direction: "",
    name: ""
  };
  // Title for the delete-user confirmation modal.
  deleteUserTitle = "Delete User";
  // Description for the delete-user confirmation modal.
  deleteUserDescription = "Are you sure you want to delete ";

  constructor(
    private userService: UserService,
    private utilsService: UtilsService,
    private loader: LoaderService) { }

  ngOnInit() {
    // Find all users in order to display them.
    this.findAll();
  }

  /**
   * Find all the users.
   */
  findAll() {
    // Show loader.
    this.loader.show();
    // Find Users.
    this.userService.findAll(this.size, (this.page - 1), this.sort.name, this.sort.direction)
    .subscribe((page: PageDTO<UserDTO>) => {
      this.users = page.content;
      this.collectionSize = page.totalElements;
      // Hide loader.
      this.loader.hide();
    });
  }

  /**
   * Update the sort object, and refetch the users.
   * 
   * @param newSort The new sort object.
   */
  getSort(newSort) {
    this.sort = {...newSort};
    this.findAll();
  }

  /**
   * Open a confirmation modal, and delete the User.
   * 
   * @param user The User to be deleted.
   */
  delete(user: UserDTO) {
    // Open the confirmation modal.
    const modal = this.utilsService.confirmation(
      this.deleteUserTitle, 
      this.deleteUserDescription + user.firstname + ' ' + user.lastname + '?'
    );

    modal.result.then(result => {
      // If the result is true, delete the user and refresh the user list.
      if (result) {
        // Show loader.
        this.loader.show();
        // Delete user.
        this.userService.delete(user.id).subscribe(result => {
          this.utilsService.showSuccess(Messages.DELETE_USER_SUCCESS);
          this.findAll();
        });
      }
    });
  }

}
