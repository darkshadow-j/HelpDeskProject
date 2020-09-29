package pl.plenczewski.backjwttest.services.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.backjwttest.models.ticket.Message;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.repository.MessageRepository;
import pl.plenczewski.backjwttest.services.mail.CreateNewMessageToTicketAspect;

import java.util.List;

@Service
public class MessageService {

    private MessageRepository messageRepository;
    private TicketService ticketService;

    @Autowired
    public MessageService(MessageRepository messageRepository, TicketService ticketService) {
        this.messageRepository = messageRepository;
        this.ticketService = ticketService;
    }

    public List<Message> getAllMessages(){
        return messageRepository.findAll();
    }

    public Message createNewMessage(Message message) {
        return messageRepository.save(message);
    }

    @CreateNewMessageToTicketAspect
    public Ticket addNewMessageToTicket(Message message, Long ticketID) {
        return ticketService.addNewMessageToTicket(this.createNewMessage(message), ticketID);

    }
}
