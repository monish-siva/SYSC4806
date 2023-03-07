package PerkManager;

import PerkManager.Classes.User;
import PerkManager.Classes.UserAccounts;
import PerkManager.Repositorys.UserAccountsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartJPAWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartJPAWebApplication.class);
    }
    @Bean
    public CommandLineRunner demo(UserAccountsRepository userAccountsRepository) {
        return (args) -> {
            User user1 = new User("admin", "password");
            User user2 = new User("someuser01", "1234");
            User user3 = new User("someuser02", "1234");
            UserAccounts userAccounts = new UserAccounts(1L); //f
            userAccounts.addUser(user1);
            userAccounts.addUser(user2);
            userAccounts.addUser(user3);
            userAccountsRepository.save(userAccounts);
        };
    }
}
