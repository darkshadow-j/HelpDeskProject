package pl.plenczewski.backjwttest.services.mail;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.plenczewski.backjwttest.models.history.Flow;
import pl.plenczewski.backjwttest.models.history.FlowHistory;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.repository.FlowHistoryRepository;

@Aspect
@Service
public class FlowHistoryService {

    private FlowHistoryRepository flowHistoryRepository;

    @AfterReturning(pointcut="@annotation(CreateNewTicketAspect)", returning = "returnTicket")
    public void newTicketHistory(Ticket returnTicket){
        FlowHistory flowHistory = new FlowHistory(returnTicket, Flow.NEW);
        flowHistoryRepository.save(flowHistory);
    }


    @AfterReturning(pointcut = "@annotation(CreateNewMessageToTicketAspect)", returning = "returnTicket")
    public void newMessageHistory(Ticket returnTicket){
        FlowHistory flowHistory = new FlowHistory(returnTicket, Flow.NEWMESSAGE);
        flowHistoryRepository.save(flowHistory);
    }

    @Autowired
    public FlowHistoryService(FlowHistoryRepository flowHistoryRepository) {
        this.flowHistoryRepository = flowHistoryRepository;
    }
}
