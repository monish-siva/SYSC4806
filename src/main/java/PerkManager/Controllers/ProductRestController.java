package PerkManager.Controllers;


import PerkManager.Classes.Product;
import PerkManager.Repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductRestController {

    private ProductRepository productRepository;

    @Autowired
    public ProductRestController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    public Product getPerk(@RequestParam("productId") Long productID) {
        Product product = productRepository.findByID(productID);
        return product;
    }

}
