package PerkManager.Controllers;

import PerkManager.Classes.Perk;
import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.UserAccountsRepository;
import PerkManager.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;

@Controller
public class UserRestController {
    private final UserRepository userRepository;
    private final UserAccountsRepository userAccountsRepository;
    @Autowired
    public UserRestController (UserRepository userRepository, UserAccountsRepository userAccountsRepository) {
        this.userRepository = userRepository;
        this.userAccountsRepository = userAccountsRepository;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam("userAccountsId") Long userAccountsID, @RequestParam ("userId") Long userID) {
        UserAccounts userAccounts = userAccountsRepository.findByID(userAccountsID);
        return userAccounts.getUserByID(userID-1);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestParam String name, @RequestParam String password) {
        UserAccounts userAccounts = userAccountsRepository.findByID(1L);
        User user = new User(name,password);
        userAccounts.addUser(user);
        userRepository.save(user);
        userAccountsRepository.save(userAccounts);
        return user;
    }

    @RequestMapping(value = "/userProfile", method = RequestMethod.POST)
    public User findUser(@RequestParam String username, @RequestParam String password) {
        UserAccounts userAccounts = userAccountsRepository.findByID(1L);
        Long userID = userAccounts.findUser(username,password);
        return userAccounts.getUserByID(userID-1);
    }
}
