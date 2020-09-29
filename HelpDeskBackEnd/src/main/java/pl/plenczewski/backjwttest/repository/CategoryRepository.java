package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.ticket.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
