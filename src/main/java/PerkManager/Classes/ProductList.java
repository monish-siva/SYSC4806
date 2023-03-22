package PerkManager.Classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_list")
public class ProductList {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> products;

    @Id
    @GeneratedValue
    private Long ID;

    public ProductList () {
        this.products = new ArrayList<Product>();
    }

    public ProductList(Long id) {
        this.setID(id);
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts(){
        return this.products;
    }

    public long getID(){
        return this.ID;
    }

    public int getProductListLength() { return this.products.size();}

    public Product getProductByID(Long id){
        return this.products.get(Math.toIntExact(id));
    }

    public void setID(Long id) {
        this.ID = id;
    }
}
