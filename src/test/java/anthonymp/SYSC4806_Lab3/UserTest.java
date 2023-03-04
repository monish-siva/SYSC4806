package anthonymp.SYSC4806_Lab3;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void getUsername() {
        User user = new User("Bob", "password");
        assertEquals("Bob", user.getUsername());
    }

    @Test
    void setUsername() {
        User user = new User();
        user.setUsername("Bob");
        assertEquals("Bob", user.getUsername());
    }

    @Test
    void getPassword() {
        User user = new User("Bob", "password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void setPassword() {
        User user = new User();
        user.setPassword("password");
        assertEquals("password", user.getPassword());
    }

    @Test
    void getID() {
        User user = new User();
        assertEquals(null, user.getID());
    }

    @Test
    void setID() {
        User user = new User();
        user.setID((long)123);
        assertEquals((long)123, user.getID());
    }
}