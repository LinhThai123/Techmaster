package vn.techmaster.demorelationship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.demorelationship.model.Category;
import vn.techmaster.demorelationship.model.Product;
import vn.techmaster.demorelationship.service.CategoryProductService;
import vn.techmaster.demorelationship.service.ProductTagService;

import java.util.Collection;

@RestController
public class APIcontroller {
    @Autowired private CategoryProductService categoryProductService;
    @Autowired private ProductTagService productTagService ;

    @GetMapping("/category")
    public Collection<Category> getAllCategory() {
        return categoryProductService.getAllCategory() ;
    }
    @GetMapping("/product")
    public Collection<Product> getAllProduct() {
        return productTagService.getAllProduct();
    }
}
