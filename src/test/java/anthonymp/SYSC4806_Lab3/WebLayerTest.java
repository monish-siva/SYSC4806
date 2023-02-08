package anthonymp.SYSC4806_Lab3;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
//tag::test[]
public class WebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(post("/addressBookCreate")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(post("/greeting")).andDo(print()).andExpect(status().isOk());

		/*this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\r\n" +
                        "" +
                        "  \"_links\" : {\r\n" +
                        "" +
                        "    \"buddyInfoes\" : {\r\n" +
                        "" +
                        "      \"href\" : \"http://localhost"+""+"/buddyInfoes\"\r\n" +
                        "" +
                        "    },\r\n" +
                        "" +
                        "    \"addressBooks\" : {\r\n" +
                        "" +
                        "      \"href\" : \"http://localhost"+"/addressBooks\"\r\n" +
                        "" +
                        "    },\r\n" +
                        "" +
                        "    \"profile\" : {\r\n" +
                        "" +
                        "      \"href\" : \"http://localhost"+"/profile\"\r\n" +
                        "" +
                        "    }\r\n" +
                        "" +
                        "  }\r\n" +
                        "" +
                        "}")));*/

	}
}
//end::test[]
