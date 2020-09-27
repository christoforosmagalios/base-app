import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { UserDTO } from '../../dto/user-dto';
import { LoaderService } from '../../shared/components/loader/loader.service';
import { Messages } from '../../shared/constants/messages';
import { UtilsService } from '../../shared/services/utils.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  // The User id.
  id: string = null;
  // The User object.
  user = new UserDTO;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private utilsService: UtilsService,
    private loader: LoaderService) { }

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.id = params['id'];
      this.initForm();
    });
  }

  /**
   * Initialize the form. If the id parameter is available,
   * fetch the user with the given id from the Database and
   * initialize the form.
   */
  initForm() {
    
    // If the id parameter is available fetch the user.
    if (this.id) {
      // Show loader.
      this.loader.show();

      this.userService.getUser(this.id).subscribe(user => {
        this.user = user;
        // Hide loader.
        this.loader.hide();
      });
    }
  }

  /**
   * Check if the form is valid and save the User.
   * 
   * @param form The NgForm.
   */
  save(form: NgForm) {
    // Check if the form is valid.
    if (!form.valid) {
      return;
    }

    // Show loader.
    this.loader.show();

    // Save the user and navigate to the users list view.
    this.userService.save(this.user).subscribe(result => {
      this.utilsService.showSuccess(Messages.SAVE_USER_SUCCESS);
      // Hide loader.
      this.loader.hide();
      // Navigate to users list view.
      this.router.navigate(['/users']);
    });

  }

}
