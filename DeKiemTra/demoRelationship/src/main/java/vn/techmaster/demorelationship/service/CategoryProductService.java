package vn.techmaster.demorelationship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demorelationship.model.Category;
import vn.techmaster.demorelationship.model.Product;
import vn.techmaster.demorelationship.repository.CategoryProductRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryProductService {
    @Autowired private CategoryProductRepo categoryProductRepo ;
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void generateProfessorDepartment() {
        Category ca1 = new Category("Car");
        Category ca2 = new Category("Moto");
        Category ca3 = new Category("Bike");


        Product pro1 = new Product("BMW I8");
        Product pro2 = new Product("Z1000");
        Product pro3 = new Product("Giant");

        ca1.add(pro1);
        ca2.add(pro2);
        ca3.add(pro3);

        em.persist(ca1);
        em.persist(ca2);
        em.persist(ca3);


        em.remove(ca3);
        em.flush();
    }
    public List<Category> getAllCategory() {
        List<Category> result = categoryProductRepo.findAll();
        return result;
    }
}
