package pl.plenczewski.backjwttest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.plenczewski.backjwttest.models.ticket.Message;
import pl.plenczewski.backjwttest.services.ticket.MessageService;
import pl.plenczewski.backjwttest.services.ticket.TicketService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

    MessageService messageService;
    TicketService ticketService;

    @Autowired
    public MessageController(MessageService messageService, TicketService ticketService) {
        this.messageService = messageService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public List<Message> getAllMessage() {
        return messageService.getAllMessages();
    }

    @PutMapping
    public ResponseEntity addNewMessageToTicket(@RequestBody Message message, @RequestParam Long ticketID) {
        messageService.addNewMessageToTicket(message, ticketID);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
