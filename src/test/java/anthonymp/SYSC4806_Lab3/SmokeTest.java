package anthonymp.SYSC4806_Lab3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomePageController homePageController;

    //Test if context is creating HomePageController
    @Test
    void contextLoads() {
        assert (homePageController != null);
    }
}
