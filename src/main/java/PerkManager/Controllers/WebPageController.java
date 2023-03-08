package PerkManager.Controllers;

import PerkManager.Classes.Perk;
import PerkManager.Classes.PerkList;
import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.PerkListRepository;
import PerkManager.Repositorys.PerkRepository;
import PerkManager.Repositorys.UserAccountsRepository;
import PerkManager.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebPageController {
    private UserAccountsRepository userAccountsRepository;
    private UserRepository userRepository;

    private PerkRepository perkRepository;

    private PerkListRepository perkListRepository;
    @Autowired
    public WebPageController(UserAccountsRepository userAccountsRepository, UserRepository userRepository, PerkRepository perkRepository, PerkListRepository perkListRepository) {
        this.userAccountsRepository = userAccountsRepository;
        this.userRepository = userRepository;
        this.perkListRepository = perkListRepository;
        this.perkRepository = perkRepository;
    }
    @GetMapping("/PerkManager")
    public void frontPage() {}

    @GetMapping("/Register")
    public String newUserForm(Model model) {
        model.addAttribute("UserAccounts", new UserAccounts());
        model.addAttribute("user", new User());
        return "Register";
    }

    @GetMapping("/Login")
    public String userLogin(Model model) {
        model.addAttribute("UserAccounts", new UserAccounts());
        model.addAttribute("userProfile", new User());
        return "Login";
    }
    @PostMapping("/newUserInfoPage")
    public String userSubmit(@ModelAttribute("user") User user) {
        UserAccounts UserAccounts = userAccountsRepository.findByID(1L);
        UserAccounts.addUser(user);
        userRepository.save(user);
        userAccountsRepository.save(UserAccounts);
        return "user";
    }

    @PostMapping("/addNewPerk")
    public String perkSubmit(@ModelAttribute("perk") Perk perks) {
        PerkList PerkList = perkListRepository.findByID(1L);
        PerkList.addPerk(perks);
        perkRepository.save(perks);
        perkListRepository.save(PerkList);
        return "perk";
    }

    @PostMapping("/userProfilePage")
    //public String userLogin(@ModelAttribute("userProfile") User user) {
    public String userLogin(User user,Model model) {
        UserAccounts UserAccounts = userAccountsRepository.findByID(1L);
        Long currentUserID = UserAccounts.findUser(user.getUsername(),user.getPassword());
        User currentUser = UserAccounts.getUserByID(currentUserID-1);
        model.addAttribute("userProfile", currentUser);
        PerkList perkList = perkListRepository.findByID(1L);

        List<Perk> perks =UserAccounts.getUserByID(currentUserID-1).getPerk();
        model.addAttribute("PerkList", perks.get(0));
        return "userProfile";
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

    @PostMapping("/addNewPerkList")
    public String perkListSubmit(Model model) {
        if (perkListRepository.findByID(1L) == null) {
            perkListRepository.save(new PerkList());
        }
        PerkList perkList = perkListRepository.findByID(1L);
        model.addAttribute("PerkList", perkList);
        return "perkList";
    }
}
