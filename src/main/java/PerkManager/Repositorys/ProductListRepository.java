package PerkManager.Repositorys;

import PerkManager.Classes.PerkList;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository {
    PerkList findByID(long id);
}
