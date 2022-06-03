package vn.techmaster.demorelationship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import vn.techmaster.demorelationship.model.Category;
import vn.techmaster.demorelationship.model.Product;
import vn.techmaster.demorelationship.repository.CategoryProductRepo;
import vn.techmaster.demorelationship.service.CategoryProductService;
import vn.techmaster.demorelationship.service.ProductTagService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class DemoRelationshipApplication implements CommandLineRunner {



    @Autowired private CategoryProductService categoryProductService ;
    @Autowired private ProductTagService productTagService ;

    public static void main(String[] args) {
        SpringApplication.run(DemoRelationshipApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        categoryProductService.generateProfessorDepartment();
        productTagService.generateArticleTag();
    }
}
