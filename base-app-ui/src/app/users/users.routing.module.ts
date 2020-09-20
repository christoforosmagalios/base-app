import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ListUsersComponent } from "./list-users/list-users.component";

const usersRoutes: Routes = [
    {
        path: 'users',
        children: [
            {path: '', component: ListUsersComponent, pathMatch: 'full'}
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(usersRoutes)],
    exports: [RouterModule]
  })
  export class UsersRoutingModule { }