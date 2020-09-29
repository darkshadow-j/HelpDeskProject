package pl.plenczewski.backjwttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.repository.AttachmentsRepository;
import pl.plenczewski.backjwttest.services.mail.MailService;
import pl.plenczewski.backjwttest.services.ticket.TicketService;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {


    @Autowired
    MailService mailService;

    TicketService ticketService;
    @Autowired
    AttachmentsRepository attachmentsRepository;
    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Ticket> createNewTicketController(@RequestBody Ticket ticket, @RequestBody MultipartFile zalacznik){
        return new ResponseEntity<>(ticketService.createNewTicket(ticket), HttpStatus.OK);
    }

    @GetMapping
    public List<Ticket> getTicketTest(){
        return ticketService.getTickets();
    }

    @GetMapping("/details")
    public Ticket getTicketDetails(@RequestParam Long id){
        return this.ticketService.getTicketByID(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public void updateTicket(@RequestBody Ticket ticket){
        ticketService.updateTicket(ticket);
    }
}
