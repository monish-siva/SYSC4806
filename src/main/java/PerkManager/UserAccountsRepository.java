package PerkManager;

import PerkManager.UserAccounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountsRepository extends CrudRepository<UserAccounts, Long> {
    UserAccounts findByID(long id);
}
