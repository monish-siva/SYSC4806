package PerkManager;

import PerkManager.Classes.*;
import PerkManager.Repositorys.PerkListRepository;
import PerkManager.Repositorys.ProductListRepository;
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
    public CommandLineRunner demo(UserAccountsRepository userAccountsRepository, PerkListRepository perkListRepository, ProductListRepository productListRepository) {
        return (args) -> {
            Perk perk1 = new Perk("ontario", "AmazonCreditCard", "AmazonPrime", "10% on Movies");
            Perk perk3 = new Perk("Toronto", "PC MasterCard", "PC Optimum", "1% of all purchases refunded as points");
            Perk perk2 = new Perk("quebec", "TDCashBackCreditCard", "", "2.5% on tech");
            PerkList perkList = new PerkList(1L);
            perkList.addPerk(perk1);
            perkList.addPerk(perk2);
            perkList.addPerk(perk3);

            Product product1 = new Product("iPhone 14");
            Product product2 = new Product("Big Mac");
            ProductList productList = new ProductList(1L);
            productList.addProduct(product1);
            productList.addProduct(product2);


            User user1 = new User("admin", "password");
            user1.addPerk(perk1); //It was found that you can't add perk1 muntiple times since it has a unique primary key ID which would cause a table violation.
            user1.addPerk(perk3);
            User user2 = new User("someuser01", "1234");
            user2.addPerk(perk2);
            User user3 = new User("someuser02", "1234");
            UserAccounts userAccounts = new UserAccounts(1L); //f
            userAccounts.addUser(user1);
            userAccounts.addUser(user2);
            userAccounts.addUser(user3);

            perkListRepository.save(perkList);
            userAccountsRepository.save(userAccounts);
            productListRepository.save(productList);


        };
    }
}

