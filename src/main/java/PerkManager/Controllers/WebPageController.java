package PerkManager.Controllers;

import PerkManager.Classes.*;
import PerkManager.Repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebPageController {
    private UserAccountsRepository userAccountsRepository;
    private UserRepository userRepository;

    private PerkRepository perkRepository;

    private PerkListRepository perkListRepository;
    private ProductListRepository productListRepository;
    @Autowired
    public WebPageController(UserAccountsRepository userAccountsRepository, UserRepository userRepository, PerkRepository perkRepository, PerkListRepository perkListRepository, ProductListRepository productListRepository) {
        this.userAccountsRepository = userAccountsRepository;
        this.userRepository = userRepository;
        this.perkListRepository = perkListRepository;
        this.perkRepository = perkRepository;
        this.productListRepository = productListRepository;
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
    public String perkSearch(Model model, @ModelAttribute("PerkList")
    MyFormObject mfo, BindingResult result) {
        PerkList pL = new PerkList();
            Long perks = pL.findPerk(mfo.getPName());
            model.addAttribute("search", perks);
            return "PerkSearch";

//        model.addAttribute("perkList", new PerkList());
//        model.addAttribute("perks", new Perk());
//        return "PerkSearch";


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

    @GetMapping("/createNewUserPerk")
    public String newPerksUserPage(Model model) {
        model.addAttribute("perks", new Perk());
        return "perks";
    }


    @PostMapping("/PerkSearch")
    public String pSearchSubmit(Model model, Perk perk){
        UserAccounts UserAccounts = userAccountsRepository.findByID(1L);
        PerkList PerkList = perkListRepository.findByID(1L);

        Long currentPerkID = PerkList.findPerk(perk.getCard());


        Perk currentPerk = PerkList.getPerkByID(currentPerkID - 1);

        model.addAttribute("Perks", currentPerk);

        PerkList perkList = perkListRepository.findByID(1L);

        Perk perky = PerkList.getPerkByID(currentPerkID-1);

        model.addAttribute("PerkList", perky);

        return "PerkSearch";
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

    @PostMapping ("/availableProductsPage")
    public String availableProductsPage(Model model) {
        if (productListRepository.findByID(1L) == null) {
            productListRepository.save(new ProductList());
        }
        ProductList productList = productListRepository.findByID(1L);
        model.addAttribute("ProductList", productList);
        return "ProductList";
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

    @PostMapping("/createNewUserPerk")
    public String createNewNewPerk(@ModelAttribute("perks") Perk perks,Model model) {
        UserAccounts accounts = userAccountsRepository.findByID(1L);
        model.addAttribute("userProfile", accounts.getCurrentUser());

        List<Perk> currentPerks = accounts.getUserByID(accounts.getCurrentUser().getID()-1).getPerk();
        currentPerks.add(perks);
        int size = currentPerks.size();
        model.addAttribute("PerkList", currentPerks);
        model.addAttribute("PerkListLength", size);

        return "userProfile";
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

    @GetMapping("/UpVotePage")
    public String upVotePerkPage(Model model) {
        model.addAttribute("perks", new Perk());
        return "UpVotePage";
    }
    @PostMapping(value = "/UpVotePage")
    public String upVotePerks(@ModelAttribute("perk") Perk perk) {
        Perk perks = perkRepository.findByID(perk.getID());
        perks.upVote();
        perkRepository.save(perks);
        //model.addAttribute("perk", perk);
        return "UpVotePage";
    }

    @GetMapping("/DownVotePage")
    public String downVotePerkPage(Model model) {
        model.addAttribute("perks", new Perk());
        return "DownVotePage";
    }
    @PostMapping("/DownVotePage")
    public String downVotePerks(@ModelAttribute("perk") Perk perk) {
        //Perk perk = perkRepository.findByID(1L);
        Perk perks = perkRepository.findByID(perk.getID());
        perks.downVote();
        perkRepository.save(perks);
        //model.addAttribute("perk", perk);
        return "DownVotePage";
    }
}
