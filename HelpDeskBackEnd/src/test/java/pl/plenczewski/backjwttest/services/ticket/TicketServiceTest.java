package pl.plenczewski.backjwttest.services.ticket;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
class TicketServiceTest {
    @Mock
    TicketRepository ticketRepository;

    @InjectMocks
    TicketService ticketService;

    Ticket ticket;
    List<Ticket> ticketList;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        prepareTicket();
        ticketList = prepareListTicket();

        given(ticketRepository.save(ticket)).willReturn(ticket);
        given(ticketRepository.findAll()).willReturn(ticketList);
        given(ticketRepository.findById(1L)).willReturn(java.util.Optional.ofNullable(ticket));
    }

    public Ticket prepareTicket(){
        ticket = new Ticket();
        ticket.setTopic("Test Topic");
        return ticket;
    }

    public List<Ticket> prepareListTicket(){
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        Ticket ticket2 = new Ticket();
        tickets.add(ticket);
        tickets.add(ticket2);
        return tickets;
    }

    @Test
    void createNewTicket() {
        Assert.assertEquals(ticketService.createNewTicket(ticket), ticket);
        Assert.assertEquals(ticketService.createNewTicket(ticket).getMessage(), ticket.getMessage());
    }

    @Test
    void getTickets() {
        Assert.assertEquals(ticketService.getTickets().size(), ticketList.size());
    }

    @Test
    void getTicketByID() {
        Assert.assertEquals(ticketService.getTicketByID(1L), ticket);
    }

    @Test
    void updateTicket() {
        ticket.setTopic("Update");
        Assert.assertEquals(ticketService.updateTicket(ticket).getTopic(), "Update");
    }

}
