package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.ticket.TicketAttachments;

@Repository
public interface AttachmentsRepository extends JpaRepository<TicketAttachments, Long> {
}
