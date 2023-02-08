package anthonymp.SYSC4806_Lab3;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    //@OneToMany //(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@ElementCollection
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> contacts;

    @Id
    @GeneratedValue
    private Long ID;

    //Base Constructor
    public AddressBook() {
        this.contacts = new ArrayList<BuddyInfo>();
    }

    public AddressBook(Long id) {
        this.setID(id);
        this.contacts = new ArrayList<BuddyInfo>();
    }
    //add a contact
    public void addContact (BuddyInfo contact) {
        this.contacts.add(contact);
    }

    //remove contact given an index
    public void removeContact (Long index) {this.contacts.remove(index);}

    //Return all contacts
    public List<BuddyInfo> getContacts () {
        return this.contacts;
    }

    public Long getID() {

        return this.ID;
    }
    public void setID(Long id) {

        this.ID = id;
    }
}
