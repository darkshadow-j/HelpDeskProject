import {Component, OnInit, TemplateRef} from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from '@angular/forms';
import {Observable} from 'rxjs';
import {debounceTime, distinctUntilChanged, map} from 'rxjs/operators';
import {AssignedTo, Ticket, TicketService, User} from '../_services/ticket.service';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenStorageService} from '../_services/token-storage.service';
import {UserService} from '../_services/user.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {Message, MessageService} from '../_services/message.service';
import {FileuploadService} from '../_services/fileupload.service';

@Component({
  selector: 'app-ticket-details',
  templateUrl: './ticket-details.component.html',
  styleUrls: ['./ticket-details.component.scss']
})
export class TicketDetailsComponent implements OnInit {

  userTable: FormGroup;
  control: FormArray;
  mode: boolean;
  touchedRows: any;
  change: boolean;
  ticketDetails: Ticket;
  priorityChange: boolean;
  selectedPriority: any;
  currentUser: AssignedTo;
  retrievedImage: any[];
  base64Data: any;
  retrieveResonse: any;

  constructor(private fileuploadService: FileuploadService, private messageService: MessageService, private modalService: NgbModal, private fb: FormBuilder, private router: Router, private ticketService: TicketService, private route: ActivatedRoute, private userService: UserService, private tokenStorageService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.retrievedImage = new Array();
    this.currentUser = this.userService.getCurrentUser();
    const ticketDetailsID = this.route.snapshot.paramMap.get('ide');
    console.log('**********');
    console.log(ticketDetailsID);
    this.ticketService.getTicketDetails(ticketDetailsID).subscribe(value => {
      this.ticketDetails = value;
      console.log('*** ' + this.ticketDetails.message.length);
    });
    this.change = true;
    this.priorityChange = true;
    this.fileuploadService.getImage(ticketDetailsID).subscribe(value => {
      console.log('xx' + value.length);
      value.forEach(value1 => {
        this.retrieveResonse = value1;
        this.base64Data = this.retrieveResonse.picByte;
        this.retrievedImage.push('data:image/jpeg;base64,' + this.base64Data);
        console.log('YY: ' + this.retrievedImage.length);
      });
    });
  }


  changes() {
    this.change = !this.change;
  }

  changePriority(): void {
    this.priorityChange = !this.priorityChange;
    console.log(this.selectedPriority);
  }

  assignToMe() {
    const assignTo: AssignedTo = ({
      id: this.currentUser.id
    });
    console.log(this.currentUser.imie);
    console.log(this.currentUser.id);
    this.ticketDetails.assignedTo = assignTo;
    this.ticketDetails.ticketFlow = 'ASSIGNED'
    this.ticketService.updateTicket(this.ticketDetails).subscribe();

    /*this.updateTicket(this.ticketDetails);*/
  }

  updateTicket(ticket: Ticket){
    this.ticketService.updateTicket(ticket).subscribe();
  }

  closeTicket(){
    this.ticketDetails.ticketFlow='CLOSE';
    this.ticketService.updateTicket(this.ticketDetails).subscribe();
  }

  openModal(exampleModalContent: TemplateRef<any>): void {
    this.modalService.open( exampleModalContent, { size : 'lg' } );
  }

  addNewMessageToTicket(value: string) {
    const users: User = ({
      id: this.currentUser.id
    });
    const newMessage: Message = ({
      message: value,
      user: users
    });
    this.messageService.addNewMessageToTicket(newMessage, this.ticketDetails.id).subscribe();
    this.modalService.dismissAll();
  }

  closeModals() {
    this.modalService.dismissAll();
  }
  carouselOption2 = {
    center: true,
    items: 2,
    loop: true,
    margin: 10,
    autoplay: true,
    autoplayTimeout: 8500,
    size: 10,
    autoWidth:true,
  }
}

