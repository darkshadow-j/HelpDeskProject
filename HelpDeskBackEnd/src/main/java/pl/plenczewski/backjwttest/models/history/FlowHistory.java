package pl.plenczewski.backjwttest.models.history;

import pl.plenczewski.backjwttest.models.ticket.Ticket;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class FlowHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Ticket ticket;

    @Enumerated
    private Flow flow;

    public FlowHistory() {
        this.setDate(LocalDate.now());
    }

    public FlowHistory(Ticket ticket, Flow flow) {
        this.setDate(LocalDate.now());
        this.ticket = ticket;
        this.flow = flow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Flow getFlow() {
        return flow;
    }

    public void setFlow(Flow flow) {
        this.flow = flow;
    }
}
