package anthonymp.SYSC4806_Lab3;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
/*

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(HomePageController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private HomePageService service;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		when(service.defaultHomePageJSON()).thenReturn("");
		this.mockMvc.perform(post("/addressBookCreate")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk());
		this.mockMvc.perform(post("/greeting")).andDo(print()).andExpect(status().isOk());


		this.mockMvc.perform(post("/addressBookCreate")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("<!DOCTYPE HTML>\n" +
						"<html>\n" +
						"<head>\n" +
						"    <title>Getting Started: Handling Form Submission</title>\n" +
						"    <meta http-equiv="+"Content-Type"+" content=\"text/html; charset=UTF-8\" />\n" +
						"</head>\n" +
						"<body>\n" +
						"<h1 style=\"background-color:Tomato;\">Current Address Book(s)</h1>\n" +
						"<p >AddressBook ID: 1</p>\n" +
						"<p>\n" +
						"    id: <b><span>1</span></b>\n" +
						"    Name: <b><span>Name1</span></b>\n" +
						"    Phone Number: <b><span>111-111-1111</span></b>\n" +
						"</p>\n" +
						"<p>\n" +
						"    id: <b><span>2</span></b>\n" +
						"    Name: <b><span>Name1</span></b>\n" +
						"    Phone Number: <b><span>222-222-2222</span></b>\n" +
						"</p>\n" +
						"<p>\n" +
						"    id: <b><span>3</span></b>\n" +
						"    Name: <b><span>Name2</span></b>\n" +
						"    Phone Number: <b><span>222-222-2222</span></b>\n" +
						"</p>\n" +
						"<a href=\"/greeting\">GO BACK</a>\n" +
						"</body>\n" +
						"</html>\"")));
	}
}
*/