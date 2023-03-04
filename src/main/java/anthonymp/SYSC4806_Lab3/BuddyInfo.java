package anthonymp.SYSC4806_Lab3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNumber;

    @Id
    @GeneratedValue
    private Long ID;

    /* Constructors */


    //Default-No-Argument-Constructor
    //Default Constructor.
    protected BuddyInfo () {
        this.phoneNumber = "";
        this.name = "";
        this.ID = null;
    }



    //Constructor#1 set name only
    public BuddyInfo (String name) {
        this();
        this.name = name;
    }
    //Constructor#2 set name and number
    public BuddyInfo (String name, String phoneNumber) {
        this(name);
        this.phoneNumber = phoneNumber;
    }

    /* Methods */

    //getter for name
    public String getName() {
        return name;
    }

    //setter for name
    public void setName(String name) {
        this.name = name;
    }

    //getter for Phone#
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //Setter for phone#
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString () {
        return "Name: " + this.name + " ; Phone #: " +  (this.phoneNumber.length() > 0 ? " " + this.phoneNumber : "") + "\n\n";
    }
    public Long getID() {
        return this.ID;
    }

    public void setID(Long id) {
        this.ID = id;
    }
}
