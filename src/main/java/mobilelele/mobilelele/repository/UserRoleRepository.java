package mobilelele.mobilelele.repository;

import mobilelele.mobilelele.model.entity.UserRole;
import mobilelele.mobilelele.model.entity.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRole(Role admin);
}
