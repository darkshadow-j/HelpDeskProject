package pl.plenczewski.backjwttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.plenczewski.backjwttest.models.stats.Statistic;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
