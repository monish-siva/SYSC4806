package PerkManager;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_accounts")
public class UserAccounts {

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> users;

    @Id
    @GeneratedValue
    private Long ID;

    //Default-No-Argument-Constructor
    //Default Constructor.
    protected UserAccounts () {
        this.users = new ArrayList<User>();
    }

    public UserAccounts(Long id) {
        this.setID(id);
        this.users = new ArrayList<User>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUserAccounts(){
        return this.users;
    }

    public User getUserByID(Long id){
        return this.users.get(Math.toIntExact(id));
    }

    public long getID(){
        return this.ID;
    }

    public void setID(Long id) {
        this.ID = id;
    }
}
