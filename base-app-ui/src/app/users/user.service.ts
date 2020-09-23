import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { PageDTO } from '../dto/page-dto';
import { UserDTO } from '../dto/user-dto';
import { Constants } from '../shared/constants/constants';

@Injectable({providedIn: 'root'})
export class UserService {

    constructor(private http: HttpClient) {

    }

    /**
     * Find users based on the given pagination parameters.
     * 
     * @param size Page size.
     * @param page The number of the page.
     * @param sort Sort column.
     * @param direction Sort direction.
     */
    findAll(size: number, page: number, sort: string, direction: string): Observable<PageDTO<UserDTO>> {
        return this.http.get<PageDTO<UserDTO>>(Constants.API + '/users?size=' + size + '&page=' + page + '&sort=' + sort + ',' + direction);
    }

}