package anthonymp.SYSC4806_Lab3;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@Value(value="${local.server.port}")
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void returnDefaultPageJSONMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",String.class));

		/*assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("{\r\n" +
				"" +
				"  \"_links\" : {\r\n" +
				"" +
				"    \"addressBooks\" : {\r\n" +
				"" +
				"      \"href\" : \"http://localhost:"+port+"/addressBooks\"\r\n" +
				"" +
				"    },\r\n" +
				"" +
				"    \"buddyInfoes\" : {\r\n" +
				"" +
				"      \"href\" : \"http://localhost:"+port+"/buddyInfoes\"\r\n" +
				"" +
				"    },\r\n" +
				"" +
				"    \"profile\" : {\r\n" +
				"" +
				"      \"href\" : \"http://localhost:"+port+"/profile\"\r\n" +
				"" +
				"    }\r\n" +
				"" +
				"  }\r\n" +
				"" +
				"}");*/
	}
}
