package pl.plenczewski.backjwttest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.plenczewski.backjwttest.models.ticket.TicketPriority;

@CrossOrigin
@RestController
@RequestMapping("/ticketpriority")
public class TicketPriorityConstroller {

    @GetMapping
    public TicketPriority[] getAllTicketPriority(){
        return TicketPriority.values();
    }

}
