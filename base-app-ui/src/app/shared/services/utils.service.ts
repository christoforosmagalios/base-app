import { Injectable } from "@angular/core";
import { NgbModal } from "@ng-bootstrap/ng-bootstrap";
import { ConfirmationModalComponent } from "../components/confirmation-modal/confirmation-modal.component";

@Injectable({providedIn: 'root'})
export class UtilsService {

    constructor(
        private _modalService: NgbModal
    ) {}

    /**
     * Open a confirmation modal with the given parameters and return
     * its instance.
     * 
     * @param title The modal title.
     * @param description The modal text content.
     */
    confirmation(title: string, description: string) {
        // Open the confirmation modal.
        const modal = this._modalService.open(ConfirmationModalComponent);
        // Pass the given parameters to the modal.
        modal.componentInstance.title = title;
        modal.componentInstance.description = description;
        // Return the modal instance.
        return modal;
    }

}