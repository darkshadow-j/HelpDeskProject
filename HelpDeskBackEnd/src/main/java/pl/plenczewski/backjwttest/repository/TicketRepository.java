package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.ticket.Message;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.models.ticket.TicketAttachments;
import pl.plenczewski.backjwttest.models.ticket.TicketFlow;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> getTicketsByTicketFlow(TicketFlow ticketFlow);
}
