import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ListUsersComponent } from "./list-users/list-users.component";
import { UserComponent } from "./user/user.component";

const usersRoutes: Routes = [
    {
        path: 'users',
        children: [
            {path: '', component: ListUsersComponent, pathMatch: 'full'}
        ]
    }, {
        path: 'user',
        children: [
            {path: '', component: UserComponent, pathMatch: 'full'},
            {path: ':id', component: UserComponent}
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(usersRoutes)],
    exports: [RouterModule]
  })
  export class UsersRoutingModule { }