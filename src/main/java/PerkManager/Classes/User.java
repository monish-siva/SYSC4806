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
    private ArrayList<Perk> perks;

    @Id
    @GeneratedValue
    private Long ID;

    public ArrayList<Perk> getPerk() {
        return perks;
    }

    public void setPerk(ArrayList<Perk> perks) {
        this.perks = perks;
    }

    /* Constructors */


    //Default-No-Argument-Constructor
    //Default Constructor.
    public User () {
        this.username = "";
        this.password = "";
        this.ID = null;
        this.perks = null;
    }

    //Constructor#2 set username and password
    public User (String username, String password, ArrayList<Perk> perks) {
        this();
        this.username = username;
        this.password = password;
        this.perks = perks;
    }

    /* Methods */

    //getter for username
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
