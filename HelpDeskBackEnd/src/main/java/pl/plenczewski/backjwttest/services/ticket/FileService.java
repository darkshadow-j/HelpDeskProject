package pl.plenczewski.backjwttest.services.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.plenczewski.backjwttest.models.ticket.Ticket;
import pl.plenczewski.backjwttest.models.ticket.TicketAttachments;
import pl.plenczewski.backjwttest.repository.AttachmentsRepository;
import pl.plenczewski.backjwttest.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {


    private AttachmentsRepository attachmentsRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public FileService(AttachmentsRepository attachmentsRepository, TicketRepository ticketRepository) {
        this.attachmentsRepository = attachmentsRepository;
        this.ticketRepository = ticketRepository;
    }

    public void uploadFile(List<TicketAttachments> ticketAttachments, String ticketID){
        Ticket ticket = this.ticketRepository.findById(Long.valueOf(ticketID)).get();
        ticket.setTicketAttachments(ticketAttachments);
        ticketRepository.save(ticket);
    }

    public Optional<TicketAttachments> findByName(String imageName) {
        return attachmentsRepository.findById(1L);
    }

    public List<TicketAttachments> findByTicketID(Long ticketID){
        return ticketRepository.findById(ticketID).get().getTicketAttachments();
    }
}

