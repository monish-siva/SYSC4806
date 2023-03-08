package PerkManager.Classes;

import jakarta.persistence.*;
import PerkManager.Classes.Perk;

@Entity
@Table(name = "user_profile") //this is requirerd or we will get a SQL jointable error.
public class User {
    private String username;
    private String password;


    private Perk perk;

    @Id
    @GeneratedValue
    private Long ID;

    public Perk getPerk() {
        return perk;
    }

    public void setPerk(Perk perk) {
        this.perk = perk;
    }

    /* Constructors */


    //Default-No-Argument-Constructor
    //Default Constructor.
    public User () {
        this.username = "";
        this.password = "";
        this.ID = null;
        this.perk = null;
    }

    //Constructor#2 set username and password
    public User (String username, String password, Perk perk) {
        this();
        this.username = username;
        this.password = password;
        this.perk = perk;
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
