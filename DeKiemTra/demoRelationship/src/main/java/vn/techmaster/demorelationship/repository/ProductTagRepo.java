package vn.techmaster.demorelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.demorelationship.model.Product;

@Repository
public interface ProductTagRepo extends JpaRepository<Product , Long> {
}
