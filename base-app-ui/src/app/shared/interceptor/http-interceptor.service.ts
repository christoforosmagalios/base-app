import { HttpErrorResponse, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { UtilsService } from "../services/utils.service";
import { catchError } from 'rxjs/operators';
import { throwError } from "rxjs";
import { Messages } from "../constants/messages";

@Injectable({providedIn: 'root'})
export class HttpInterceptorService implements HttpInterceptor {
  constructor(private utilsService: UtilsService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler) {
    return next.handle(request)
        .pipe(
            catchError((error: HttpErrorResponse) => {
                // Display error toaster.
                this.utilsService.showError(Messages.GENERIC_ERROR);
                return throwError(error.error.message);
            })
        );
  }
}