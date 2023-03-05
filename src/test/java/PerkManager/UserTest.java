package PerkManager;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void getUsername() {
        User user = new User("Bob", "password");
        Assertions.assertEquals("Bob", user.getUsername());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("Bob");
        Assertions.assertEquals("Bob", user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User("Bob", "password");
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("password");
        Assertions.assertEquals("password", user.getPassword());
    }

    @Test
    void getID() {
        User user = new User();
        Assertions.assertEquals(null, user.getID());
    }

    @Test
    void setID() {
        User user = new User();
        user.setID((long)123);
        Assertions.assertEquals((long)123, user.getID());
    }
}