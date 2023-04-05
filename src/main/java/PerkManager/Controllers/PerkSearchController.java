package PerkManager.Controllers;

import PerkManager.Classes.Perk;
import PerkManager.Classes.PerkService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PerkSearchController {

    @Autowired
    private PerkService service;

    @GetMapping(path = {"/","/search"})
    public String home(Perk perk, Model model, String keyword) {
        if(keyword!=null) {
            List<Perk> list = service.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Perk> list = service.getAllPerks();
            model.addAttribute("list", list);}
        return "Index";
    }
}
