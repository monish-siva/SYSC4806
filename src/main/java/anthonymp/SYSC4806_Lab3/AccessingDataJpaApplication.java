
package anthonymp.SYSC4806_Lab3;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class AccessingDataJpaApplication {

    //private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository buddyRepository, AddressBookRepository addressBookRepository) {
        return (args) -> {
            BuddyInfo b1 = new BuddyInfo("Name1", "111-111-1111");
            BuddyInfo b2 = new BuddyInfo("Name1", "222-222-2222");
            BuddyInfo b3 = new BuddyInfo("Name2", "222-222-2222");
            AddressBook a1 = new AddressBook(1L);
            a1.addContact(b1);
            a1.addContact(b2);
            a1.addContact(b3);
            addressBookRepository.save(a1);
        };




        /*@Bean
        public CommandLineRunner demo(BuddyInfoRepository buddyRepository, AddressBookRepository abRepository) {
            return (args) -> {

                //buddyRepository.save(new BuddyInfo("Name1", "111-111-1111"));
                //buddyRepository.save(new BuddyInfo("Name1", "222-222-2222"));
                //buddyRepository.save(new BuddyInfo("Name2", "222-222-2222"));
                //buddyRepository.save(new BuddyInfo("Only Name")); //Only Name Buddy Info
                //buddyRepository.save(new BuddyInfo());  //Empty BuddyInfo






                BuddyInfo b1 = new BuddyInfo("Name1", "111-111-1111");
                BuddyInfo b2 = new BuddyInfo("Name1", "222-222-2222");
                BuddyInfo b3 = new BuddyInfo("Name2", "222-222-2222");
                AddressBook a1 = new AddressBook(1L);
                a1.addContact(b1);
                a1.addContact(b2);
                a1.addContact(b3);












            /*
            // fetch all BuddyInfos
            log.info("BuddyInfos found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyinfo : buddyRepository.findAll()) {
                log.info(buddyinfo.toString());
            }
            log.info(""); //record it

            // fetch an BuddyInfo by ID
            BuddyInfo buddyinfo = buddyRepository.findByID(1L);
            log.info("BuddyInfo found with findById(1L):");
            log.info("--------------------------------");
            log.info(buddyinfo.toString());
            log.info("");

            // fetch BuddyInfos by  name, for Name1
            log.info("BuddyInfo found with name('Name1'):");
            log.info("--------------------------------------------");
            buddyRepository.findByName("Name1").forEach(buddyName -> {
                log.info(buddyName.toString());
            });

            // fetch BuddyInfos by  phoneNumber, for Name1
            log.info("BuddyInfo found with findByPhoneNumber('222-222-2222'):");
            log.info("--------------------------------------------");
            buddyRepository.findByPhoneNumber("222-222-2222").forEach(buddyNumber -> {
                log.info(buddyNumber.toString());
            });

            log.info("");

            };*/
    }
}
