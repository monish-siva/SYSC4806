package PerkManager.Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountsTest {

    //test for addUser method
    @Test
    void addUser() {
        UserAccounts account = new UserAccounts();
        User user1 = new User("user1", "password");
        User user2 = new User("user2", "password");
        List<User> list = new ArrayList<>();
        account.addUser(user1);
        list.add(user1);
        assertEquals(list, account.getUserAccounts());
        account.addUser(user2);
        list.add(user2);
        assertEquals(list, account.getUserAccounts());
    }

    @Test
    void getUserAccounts() {
    }

    @Test
    void getUserByID() {
    }

    @Test
    void getID() {
    }

    @Test
    void setID() {
    }
}