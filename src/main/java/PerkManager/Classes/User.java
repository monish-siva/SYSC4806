package PerkManager.Classes;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_profile") //this is requirerd or we will get a SQL jointable error.
public class User {
    private String username;
    private String password;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Perk> perks;

    @Id
    @GeneratedValue
    private Long ID;

    /* Constructors */


    //Default-No-Argument-Constructor
    //Default Constructor.
    public User () {
        this.username = "";
        this.password = "";
        this.ID = null;
        this.perks = new ArrayList<Perk>();
    }

    //Constructor#2 set username and password
    public User (String username, String password) {
        this();
        this.username = username;
        this.password = password;
        this.perks = new ArrayList<Perk>();
    }

    /* Methods */

    //getter for username

    public List<Perk> getPerk() {
        return this.perks;
    }

    public void addPerk(Perk perk) {
        this.perks.add(perk);
    }

    public String getUsername() {
        return this.username;
    }

    //setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    //getter for password
    public String getPassword() {
        return this.password;
    }

    //setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter for ID
    public Long getID() {
        return this.ID;
    }

    //setter for ID
    public void setID(Long id) {
        this.ID = id;
    }
}
