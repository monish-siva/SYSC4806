package PerkManager.WebLayers;

import static org.assertj.core.api.Assertions.assertThat;

import PerkManager.Controllers.WebPageController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private WebPageController webPageController;

    //Test if context is creating HomePageController
    @Test
    void contextLoads() {
        assert (webPageController != null);
    }
}
