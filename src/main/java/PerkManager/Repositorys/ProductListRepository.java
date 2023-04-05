package PerkManager.Repositorys;

import PerkManager.Classes.PerkList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends CrudRepository<PerkList, Integer> {
    PerkList findByID(long id);

}
