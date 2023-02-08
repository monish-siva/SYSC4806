package anthonymp.SYSC4806_Lab3;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
/*
@WebMvcTest(HomePageController.class)
public class GetRequestTests {


    //RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private MockMvc mockMvc;

    String homePageURL = "http://localhost:8080/greeting";
    ResponseEntity<String> response = mockMvc.getDispatcherServlet(homePageURL + "", String.class);


    @Test
    public void testGetRequestsTest() {
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void httpHeadersRequestTest() {
        //HttpHeaders httpHeaders = restTemplate.headForHeaders(homePageURL);
        //Assertions.assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }
}*/
