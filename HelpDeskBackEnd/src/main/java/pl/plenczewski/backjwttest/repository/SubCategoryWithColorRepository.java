package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.stats.SubCategoryWithColor;

@Repository
public interface SubCategoryWithColorRepository extends JpaRepository<SubCategoryWithColor,Long> {
}
