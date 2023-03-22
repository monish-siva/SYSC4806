package PerkManager.Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductListTest {

    @Test
    void addProductAndGetProductsAndGetProductListLength() {
        ProductList products = new ProductList();
        Product product1 = new Product("iPhone");
        Product product2 = new Product("iPad");
        List<Product> list = new ArrayList<>();
        assertEquals(list, products.getProducts());
        assertEquals(0, products.getProductListLength());
        products.addProduct(product1);
        list.add(product1);
        assertEquals(list, products.getProducts());
        assertEquals(1, products.getProductListLength());
        products.addProduct(product2);
        list.add(product2);
        assertEquals(list, products.getProducts());
        assertEquals(2, products.getProductListLength());
    }

    @Test
    void getID() {
        ProductList products = new ProductList((long)123);
        assertEquals(123, products.getID());
    }

    @Test
    void getProductByID() {
        Product product1 = new Product();
        Product product2 = new Product();
        ProductList products = new ProductList();
        products.addProduct(product1);
        products.addProduct(product2);
        assertEquals(product1, products.getProductByID((long)0));
        assertEquals(product2, products.getProductByID((long)1));
    }

    @Test
    void setID() {
        ProductList products = new ProductList();
        products.setID((long)123);
        assertEquals(123, products.getID());
    }
}