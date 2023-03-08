package PerkManager.Controllers;

import PerkManager.Classes.Perk;
import PerkManager.Classes.PerkList;
import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.PerkListRepository;
import PerkManager.Repositorys.PerkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PerkRestController {

    private PerkRepository perkRepository;
    private PerkListRepository perkListRepository;

    @Autowired
    public  PerkRestController(PerkRepository perkRepository, PerkListRepository perkListRepository){
        this.perkRepository = perkRepository;
        this.perkListRepository = perkListRepository;
    }

    @RequestMapping(value = "/Perk", method = RequestMethod.GET)
    public Perk getPerk(@RequestParam("perkId") Long perkID) {
        Perk perk = perkRepository.findByID(perkID);
        return perk;
    }

    @RequestMapping(value = "/Perk", method = RequestMethod.POST)
    public Perk addPerk(@RequestParam String location, @RequestParam String card, @RequestParam String membership, @RequestParam String discount) {
        PerkList perkList = perkListRepository.findByID(1L);
        Perk perk = new Perk(location, card, membership, discount);
        perkList.addPerk(perk);
        perkRepository.save(perk);
        perkListRepository.save(perkList);
        return perk;
    }

}
