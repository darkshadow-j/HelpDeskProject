package pl.plenczewski.backjwttest.models.ticket;


import pl.plenczewski.backjwttest.models.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String topic;

    @ManyToOne
    private User user;

    @ManyToOne
    private User assignedTo;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Message> message;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Subcategory subcategory;

    private String description;

    private LocalDate createTicketDate;

    @Enumerated
    private TicketPriority ticketPriority;

    @Enumerated
    private TicketFlow ticketFlow;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TicketAttachments> ticketAttachments;

    public Ticket() {
        this.setCreateTicketDate(LocalDate.now());
        this.setTicketFlow(TicketFlow.NEW);
        this.setTicketPriority(TicketPriority.MEDIUM);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreateTicketDate() {
        return createTicketDate;
    }

    public void setCreateTicketDate(LocalDate createTicketDate) {
        this.createTicketDate = createTicketDate;
    }

    public TicketPriority getTicketPriority() {
        return ticketPriority;
    }

    public void setTicketPriority(TicketPriority ticketPriority) {
        this.ticketPriority = ticketPriority;
    }

    public TicketFlow getTicketFlow() {
        return ticketFlow;
    }

    public void setTicketFlow(TicketFlow ticketFlow) {
        this.ticketFlow = ticketFlow;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }


    public void addMessage(Message message){
        this.getMessage().add(message);
    }

    public List<TicketAttachments> getTicketAttachments() {
        return ticketAttachments;
    }

    public void setTicketAttachments(List<TicketAttachments> ticketAttachments) {
        this.ticketAttachments = ticketAttachments;
    }
}
