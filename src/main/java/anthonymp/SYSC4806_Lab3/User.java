package anthonymp.SYSC4806_Lab3;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class User {
    private String username;
    private String password;

    @Id
    @GeneratedValue
    private Long ID;

    /* Constructors */


    //Default-No-Argument-Constructor
    //Default Constructor.
    protected User () {
        this.username = "";
        this.password = "";
        this.ID = null;
    }

    //Constructor#2 set username and password
    public User (String username, String password) {
        this();
        this.username = username;
        this.password = password;
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

    //Setter for phone#
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
