package vn.techmaster.demorelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.demorelationship.model.Category;

public interface CategoryProductRepo extends JpaRepository<Category , Long> {
}
