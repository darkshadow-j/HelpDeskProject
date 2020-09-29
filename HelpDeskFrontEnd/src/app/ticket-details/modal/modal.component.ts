import { Component, OnInit } from '@angular/core';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  openModal( exampleModalContent ) {
    this.modalService.open( exampleModalContent, { size : 'lg' } );
  }

  openMediumModal( mediumModalContent ) {
    this.modalService.open( mediumModalContent );
  }

  openSmallModal( smallModalContent ) {
    this.modalService.open( smallModalContent, { size : 'sm' } );
  }

}
