package PerkManager.Classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    //The name of the product
    private String name;

    //The perks that can be applied to this product
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Perk> perks;

    //Product ID
    @Id
    @GeneratedValue
    private Long ID;

    //Default-No-Argument-Constructor
    //Default Constructor.
    public Product(){
        this.name="";
        this.perks=new ArrayList<>();
    }

    //Constructor with name argument
    public Product(String name){
        this.name="";
        this.perks=new ArrayList<>();
    }

    //method that gets the name of the product
    public String getName() {
        return this.name;
    }

    //method that sets the name of the product
    public void setName(String name) {
        this.name = name;
    }

    //adds a perk to the list of perks
    public void addPerk(Perk perk) {
        this.perks.add(perk);
    }

    //removes a perk from the list of perks
    public void removePerk(Perk perk) {
        this.perks.remove(perk);
    }

    //checks if a perk is in the list of perks
    public boolean containsPerk(Perk perk) {
       return this.perks.contains(perk);
    }

    //gets the ID of the perk
    public Long getID() {
        return ID;
    }

    //sets the ID of the perk
    public void setID(Long ID) {
        this.ID = ID;
    }
}
