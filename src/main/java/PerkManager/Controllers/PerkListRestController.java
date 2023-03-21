package PerkManager.Controllers;

import PerkManager.Classes.PerkList;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.PerkListRepository;
import PerkManager.Repositorys.UserAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerkListRestController {

    private PerkListRepository plRepository;
    @Autowired
    public PerkListRestController(PerkListRepository plRepository) {

        this.plRepository = plRepository;
    }
    @RequestMapping("/perkList")
    public PerkList createUserAccount(){
        PerkList perkList = new PerkList();
        plRepository.save(perkList);
        return perkList;
    }
    @RequestMapping(value = "/perkLists", method = RequestMethod.GET)
    public PerkList getPerkList(@RequestParam("id") Long id){
        return plRepository.findByID(id);
    }

}
