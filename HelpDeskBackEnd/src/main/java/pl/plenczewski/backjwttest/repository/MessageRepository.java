package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.ticket.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {


}
