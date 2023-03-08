package PerkManager.Controllers;

import PerkManager.Classes.Perk;
import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.PerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerkRestController {

    private PerkRepository perkRepository;

    @Autowired
    public  PerkRestController(PerkRepository perkRepository){
        this.perkRepository = perkRepository;
    }

    @RequestMapping(value = "/Perk", method = RequestMethod.GET)
    public Perk getPerk(@RequestParam("perkId") Long perkID) {
        Perk perk = perkRepository.findByID(perkID);
        return perk;
    }

}
