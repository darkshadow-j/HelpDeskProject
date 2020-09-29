import {Component, OnInit, ViewChild} from '@angular/core';
import {Category, SubCategory, Ticket, TicketAttachment, TicketService, User} from '../_services/ticket.service';
import {UserService} from '../_services/user.service';
import {CategoryService} from '../_services/category.service';
import {DropzoneComponent} from 'ngx-dropzone-wrapper';
import {FileuploadService} from '../_services/fileupload.service';
import {Router} from '@angular/router';
import {SwalComponent} from '@sweetalert2/ngx-sweetalert2';

@Component({
  selector: 'app-newticket',
  templateUrl: './newticket.component.html',
  styleUrls: ['./newticket.component.scss']
})
export class NewticketComponent implements OnInit {

  @ViewChild('autoSwal', {static: true}) private swalComponent: SwalComponent;

  files: File[] = [];
  currentUser: User;
  category: Category[];
  selectedCategory: Category;
  selectedSubCategory: SubCategory;
  ticketAttachments: TicketAttachment[];


  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  imageName: any;

  newTicket: Ticket;

  constructor(private router: Router, private fileuploadService: FileuploadService, private ticketService: TicketService, private userService: UserService, private categoryService: CategoryService) {
  }

  ngOnInit(): void {
    this.currentUser = this.userService.getCurrentUser();
    this.categoryService.getAllTicket().subscribe(value => {
      this.category = value;

    });
  }

  onSubmit(title: string, descriptionText: string, drop: DropzoneComponent): void {
    const users: User = ({
      id: this.currentUser.id
    });


    const ticket: Ticket = ({
      description: descriptionText,
      category: this.selectedCategory,
      subcategory: this.selectedSubCategory,
      user: users,
      topic: title
    });
    ;
    this.ticketService.createNewTicket(ticket).subscribe(value => {
      this.newTicket = value;
      console.log(value.id);
      console.log('file: ', this.files.length);
      this.fileuploadService.uploadFile(this.files,this.newTicket.id).subscribe();
      this.router.navigate(['/details', {ide: value.id}]);
    });

  }

  onSelect(event) {
    this.ticketAttachments = new Array();
    console.log(event);
    this.files.push(...event.addedFiles);
    const formData = new FormData();

    for (var i = 0; i < this.files.length; i++) {
      formData.append('file[]', this.files[i]);
      const ticketAttachments: TicketAttachment = ({
        attachment: this.files[i],
        name: 'sa'
      });
      /* this.ticketAttachments.push(ticketAttachments);*/
    }
    console.log('******************');
    console.log(this.ticketAttachments.length);
  }

  onRemove(event) {
    console.log(event);
    this.files.splice(this.files.indexOf(event), 1);
  }

/*  getImage() {
    this.fileuploadService.getImage().subscribe(
      res => {
        this.retrieveResonse = res;
        this.base64Data = this.retrieveResonse.picByte;
        this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
      }
    );
  }*/
}
