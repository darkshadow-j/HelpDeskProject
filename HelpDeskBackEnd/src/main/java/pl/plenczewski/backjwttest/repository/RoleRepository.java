package pl.plenczewski.backjwttest.repository;

import pl.plenczewski.backjwttest.models.ERole;
import pl.plenczewski.backjwttest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
