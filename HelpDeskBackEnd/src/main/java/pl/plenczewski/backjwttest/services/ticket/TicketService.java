package pl.plenczewski.backjwttest.services.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.backjwttest.models.ticket.Message;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.repository.TicketRepository;
import pl.plenczewski.backjwttest.services.mail.CreateNewTicketAspect;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @CreateNewTicketAspect
    public Ticket createNewTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }


    public List<Ticket> getTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketByID(Long id){
        return ticketRepository.findById(id).get();
    }


    public Ticket updateTicket(Ticket ticket){
        return ticketRepository.save(ticket);

    }

    public Ticket addNewMessageToTicket(Message message, Long id){
        Optional<Ticket> ticket = ticketRepository.findById(id);
        Ticket ticketWithMessage = ticket.get();
        ticketWithMessage.addMessage(message);
        return ticketRepository.save(ticketWithMessage);
    }

}
