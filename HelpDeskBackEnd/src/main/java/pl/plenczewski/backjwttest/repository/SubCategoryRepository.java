package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.ticket.Subcategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<Subcategory, Long> {
}
