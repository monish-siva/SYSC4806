package anthonymp.SYSC4806_Lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/*GET http://localhost:8080/addressBooks/1/contacts
DELETE http://localhost:8080/addressBooks/1/contacts/1

http://localhost:8080/greeting?name=User
http://localhost:8080/create2?name=Jim?phone#=0001112222
http://localhost:8080/create2?name=Bob&phoneNumber=6*/

@Controller
public class HomePageController {


    private AddressBookRepository addressBookRepository;
    private BuddyInfoRepository buddyInfoRepository;

    @Autowired
    public HomePageController(AddressBookRepository addressBookRepository, BuddyInfoRepository buddyInfoRepository) {
        this.addressBookRepository = addressBookRepository;
        this.buddyInfoRepository = buddyInfoRepository;
    }

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("addressBook", new AddressBook());
        model.addAttribute("buddy", new BuddyInfo());
        model.addAttribute("buddyRemove");
        return "greeting";
    }

    @PostMapping("/buddyAdd")
    public String buddySubmit(@ModelAttribute("buddy") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findByID(1L);
        addressBook.addContact(buddyInfo);
        buddyInfoRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
        return "buddy";
    }

    @PostMapping("/buddyRemove")
    public String buddyRemove(@ModelAttribute("buddyRemove") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findByID(1L);
        addressBook.removeContact(buddyInfo.getID());
        buddyInfoRepository.deleteById(buddyInfo.getID());
        addressBookRepository.save(addressBook);
        //addressBookRepository.save(addressBook);
        return "buddyRemove";
    }

    @PostMapping("/addressBookCreate")
    public String addressBookSubmit(Model model) {
        if (addressBookRepository.findByID(1L) == null) {
            addressBookRepository.save(new AddressBook());
        }
        AddressBook addressBook = addressBookRepository.findByID(1L);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }
}
