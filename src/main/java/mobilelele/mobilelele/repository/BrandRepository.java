package mobilelele.mobilelele.repository;

import mobilelele.mobilelele.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Long> {
    Brand findByName(String brand);
}
