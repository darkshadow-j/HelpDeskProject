import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalComponent } from './modal/modal.component';
import { CarouselModule } from 'ngx-owl-carousel-o';



@NgModule({
  declarations: [ModalComponent],
  exports: [
    ModalComponent
  ],
  imports: [
    CommonModule,
  ]
})
export class TicketDetailsModule { }
