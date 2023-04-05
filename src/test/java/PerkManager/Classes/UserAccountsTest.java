package PerkManager.Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountsTest {

    //test for addUser and getUserAccounts methods
    @Test
    void addUserAndGetUserAccounts() {
        UserAccounts account = new UserAccounts();
        User user1 = new User("user1", "password");
        User user2 = new User("user2", "password");
        List<User> list = new ArrayList<>();
        assertEquals(list, account.getUserAccounts());
        account.addUser(user1);
        list.add(user1);
        assertEquals(list, account.getUserAccounts());
        account.addUser(user2);
        list.add(user2);
        assertEquals(list, account.getUserAccounts());
    }

    //test the getUserByID method
    @Test
    void getUserByID() {
        UserAccounts account = new UserAccounts();
        User user1 = new User("user1", "password");
        User user2 = new User("user2", "password");
        account.addUser(user1);
        account.addUser(user2);
        assertEquals(user1, account.getUserByID((long)0));
        assertEquals(user2, account.getUserByID((long)1));
    }

    @Test
    void getCurrentUser() {
        UserAccounts account = new UserAccounts();
        User user1 = new User("user1", "password");
        User user2 = new User("user2", "password");
        account.addUser(user1);
        account.addUser(user2);
        assertEquals(account.getCurrentUser(), null);
    }

    //test the getID method
    @Test
    void getID() {
        UserAccounts account = new UserAccounts((long)123);
        assertEquals(123, account.getID());
    }

    //test the setID method
    @Test
    void setID() {
        UserAccounts account = new UserAccounts();
        account.setID((long)123);
        assertEquals(123, account.getID());
    }
}