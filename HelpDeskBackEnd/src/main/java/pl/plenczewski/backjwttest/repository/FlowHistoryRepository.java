package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.history.FlowHistory;

@Repository
public interface FlowHistoryRepository extends JpaRepository<FlowHistory, Long> {
}
