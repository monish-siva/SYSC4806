package PerkManager.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import PerkManager.Classes.Perk;

@Repository
public interface PerkRepository extends CrudRepository<Perk, Long> {
    Perk findByID(long id);

}
