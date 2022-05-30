package mobilelele.mobilelele.repository;

import mobilelele.mobilelele.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Long> {
}
