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

    @GetMapping("/PerkSearch")
    public String perkSearch(Model model){
        model.addAttribute("Search", new PerkList());
        return "PerkSearch";
    }

   /*@GetMapping("/availablePerksPage")
    public String perksPage(Model model) {
        model.addAttribute("PerkList", new PerkList());
        return "PerkList";
    }*/

    @GetMapping("/createNewPerk")
    public String newPerksPage(Model model) {
        model.addAttribute("perks", new Perk());
        return "perks";
    }

    @PostMapping ("/availablePerksPage")
    public String availablePerksPage(Model model) {
        if (perkListRepository.findByID(1L) == null) {
            perkListRepository.save(new PerkList());
        }
        PerkList perkList = perkListRepository.findByID(1L);
        model.addAttribute("PerkList", perkList);
        return "PerkList";
    }



    @PostMapping("/newUserInfoPage")
    public String userSubmit(@ModelAttribute("user") User user) {
        UserAccounts UserAccounts = userAccountsRepository.findByID(1L);
        UserAccounts.addUser(user);
        userRepository.save(user);
        userAccountsRepository.save(UserAccounts);
        return "user";
    }

    @PostMapping("/createNewPerk")
    public String createNewPerk(@ModelAttribute("perks") Perk perks) {
        PerkList PerkList = perkListRepository.findByID(1L);
        PerkList.addPerk(perks);
        perkRepository.save(perks);
        perkListRepository.save(PerkList);
        return "perks";
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
        int size = perks.size();
        model.addAttribute("PerkList", perks);
        model.addAttribute("PerkListLength", size);
        return "userProfile";
    }

    @PostMapping("/availablePerks")
    public String availablePerks(Model model) {
        PerkList perkList = perkListRepository.findByID(1L);
        model.addAttribute("perkLists", perkList);
        return "perkLists";
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

    @PostMapping("/upVote")
    public String upVotePerks(@ModelAttribute("perk") Perk perk) {
        Perk perks = perkRepository.findByID(perk.getID());
        perks.upVote();
        perkRepository.save(perks);
        //model.addAttribute("perk", perk);
        return "perk";
    }

    @PostMapping("/downVote")
    public String downVotePerks(@ModelAttribute("perk") Perk perk) {
        //Perk perk = perkRepository.findByID(1L);
        Perk perks = perkRepository.findByID(perk.getID());
        perks.downVote();
        perkRepository.save(perks);
        //model.addAttribute("perk", perk);
        return "perk";
    }
}
