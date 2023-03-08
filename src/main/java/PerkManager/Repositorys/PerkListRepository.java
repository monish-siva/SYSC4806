package PerkManager.Repositorys;

import PerkManager.Classes.PerkList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerkListRepository extends CrudRepository<PerkList, Long> {
    PerkList findByID(long id);
}
