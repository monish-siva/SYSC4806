package PerkManager.Controllers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(WebPageController.class)
class WebPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountsRepository userAccountsRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PerkRepository perkRepository;

    @MockBean
    private PerkListRepository perkListRepository;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductListRepository productListRepository;

    @Test
    void frontPage() throws Exception {
        this.mockMvc.perform(get("/PerkManager"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void newUserForm() throws Exception {
        this.mockMvc.perform(get("/Register"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Create a New Account")))
                .andExpect(model().attributeExists("UserAccounts"))
                .andExpect(model().attributeExists("user"));
    }

    @Test
    void userLogin() throws Exception {
        this.mockMvc.perform(get("/Login"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Login To User Account")))
                .andExpect(model().attributeExists("UserAccounts"))
                .andExpect(model().attributeExists("userProfile"));
    }

    @Test
    void perkSearchPage() throws Exception {
        this.mockMvc.perform(get("/PerkSearch"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Perk Search")));
    }

    @Test
    void addUserPerk() throws Exception {
        this.mockMvc.perform(get("/createNewUserPerk"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Perk")));
    }
}