import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListUsersComponent } from './list-users/list-users.component';
import { UsersRoutingModule } from './users.routing.module';
import { UserComponent } from './user/user.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DirectivesModule } from '../shared/directives/directives.module';



@NgModule({
  declarations: [ListUsersComponent, UserComponent],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule,
    NgbModule,
    DirectivesModule
  ]
})
export class UsersModule { }
