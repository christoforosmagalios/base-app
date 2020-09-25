import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListUsersComponent } from './list-users/list-users.component';
import { UsersRoutingModule } from './users.routing.module';
import { UserComponent } from './user/user.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [ListUsersComponent, UserComponent],
  imports: [
    CommonModule,
    UsersRoutingModule,
    FormsModule
  ]
})
export class UsersModule { }
