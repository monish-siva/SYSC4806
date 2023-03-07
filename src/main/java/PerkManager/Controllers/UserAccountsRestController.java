package PerkManager.Controllers;

import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.UserAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserAccountsRestController {
    private UserAccountsRepository userAccountsRepository;
    @Autowired
    public UserAccountsRestController(UserAccountsRepository userAccountsRepository) {
        this.userAccountsRepository = userAccountsRepository;
    }
    @RequestMapping("/userAccount")
    public UserAccounts createUserAccount(){
        UserAccounts userAccounts = new UserAccounts();
        userAccountsRepository.save(userAccounts);
        return userAccounts;
    }
    @RequestMapping(value = "/userAccount", method = RequestMethod.GET)
    public UserAccounts getUserAccounts(@RequestParam("id") Long id){
        return userAccountsRepository.findByID(id);
    }

}
