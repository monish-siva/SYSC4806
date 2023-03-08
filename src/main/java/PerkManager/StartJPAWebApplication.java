package PerkManager;

import PerkManager.Classes.Perk;
import PerkManager.Classes.PerkList;
import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.PerkListRepository;
import PerkManager.Repositorys.UserAccountsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class StartJPAWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartJPAWebApplication.class);
    }
    @Bean
    public CommandLineRunner demo(UserAccountsRepository userAccountsRepository, PerkListRepository perkListRepository) {
        return (args) -> {
            Perk perk1 = new Perk("ontario", "AmazonCreditCard", "AmazonPrime", "10% on Movies");
            Perk perk2 = new Perk("quebec", "TDCashBackCreditCard", "", "2.5% on tech");
            PerkList perkList = new PerkList(1L);
            perkList.addPerk(perk1);
            perkList.addPerk(perk2);
            perkListRepository.save(perkList);

            ArrayList<Perk> perks = new ArrayList<>();
            perks.add(perk1);
            perks.add(perk2);

            User user1 = new User("admin", "password", perks );
            User user2 = new User("someuser01", "1234", perks);
            User user3 = new User("someuser02", "1234", perks);
            UserAccounts userAccounts = new UserAccounts(1L); //f
            userAccounts.addUser(user1);
            userAccounts.addUser(user2);
            userAccounts.addUser(user3);
            userAccountsRepository.save(userAccounts);


        };
    }
}

