package PerkManager.Classes;


import java.util.List;

import PerkManager.Classes.Perk;
import PerkManager.Repositorys.PerkRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerkService {


    @Autowired
    private PerkRepository repository;

    public PerkService(){}

    public List<Perk> getAllPerks(){
        List<Perk> list =  repository.findAll();
        return list;
    }


    public List<Perk> getByKeyword(String keyword){
        return repository.findByKeyword(keyword);
    }
}
