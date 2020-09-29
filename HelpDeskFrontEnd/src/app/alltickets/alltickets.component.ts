import {Component, OnInit} from '@angular/core';
import {Ticket, TicketService} from '../_services/ticket.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-alltickets',
  templateUrl: './alltickets.component.html',
  styleUrls: ['./alltickets.component.scss']
})
export class AllticketsComponent implements OnInit {

  tickets: Ticket[];

  constructor(private ticketService: TicketService, private router: Router) {
  }

  ngOnInit(): void {
    this.ticketService.getAllTickets().subscribe(value => {
      this.tickets = value;
    });
  }

  showDetails(id: number) {
    this.router.navigate(['/details', {ide: id}]);
  }
}
