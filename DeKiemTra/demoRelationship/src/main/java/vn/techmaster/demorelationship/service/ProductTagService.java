package vn.techmaster.demorelationship.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.demorelationship.model.Product;
import vn.techmaster.demorelationship.model.Tag;
import vn.techmaster.demorelationship.repository.ProductTagRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductTagService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ProductTagRepo productTagRepo;

    @Transactional
    public void generateArticleTag() {
        Tag sport = new Tag("Sport");
        Tag fashion = new Tag("Fashion");
        Tag technology = new Tag("Technology");

        Product pro1 = new Product("BMW Giá đang trên trời ");
        Product pro2 = new Product("Mua `1 chiếc xe máy ngon ơi là ngon ");
        Product pro3 = new Product("Ronaldo sang Việt nam thi đấu");

        pro1.addTag(sport);
        pro2.addTag(fashion);
        pro3.addTag(technology);

        em.persist(sport);
        em.persist(fashion);
        em.persist(technology);

        em.persist(pro1); em.persist(pro2); em.persist(pro3);

    }
    public List<Product> getAllProduct() {
        return productTagRepo.findAll();
    }
}
