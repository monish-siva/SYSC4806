package PerkManager.Controllers;

import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.UserAccountsRepository;
import PerkManager.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebPageController {
    private UserAccountsRepository userAccountsRepository;
    private UserRepository userRepository;
    @Autowired
    public WebPageController(UserAccountsRepository userAccountsRepository, UserRepository userRepository) {
        this.userAccountsRepository = userAccountsRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/tbd")
    public String userForm(Model model) {
        model.addAttribute("UserAccounts", new UserAccounts());
        model.addAttribute("user", new User());
        return "tbd";
    }
    @PostMapping("/registerNewUser")
    public String userSubmit(@ModelAttribute("buddy") User user) {
        UserAccounts UserAccounts = userAccountsRepository.findByID(1L);
        UserAccounts.addUser(user);
        userRepository.save(user);
        userAccountsRepository.save(UserAccounts);
        return "user";
    }

    /*@PostMapping("/removeUser")
    public String removeUser(@RequestParam Long UserAccountsID, Long userID) {
    }*/
    @PostMapping("/addNewUserAccount")
    public String userAccountSubmit(Model model) {
        if (userAccountsRepository.findByID(1L) == null) {
            userAccountsRepository.save(new UserAccounts());
        }
        UserAccounts userAccounts = userAccountsRepository.findByID(1L);
        model.addAttribute("userAccounts", userAccounts);
        return "userAccounts";
    }
}
