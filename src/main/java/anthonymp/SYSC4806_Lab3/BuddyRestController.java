package anthonymp.SYSC4806_Lab3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuddyRestController {

    private final BuddyInfoRepository buddyInfoRepository;
    private final AddressBookRepository addressBookRepository;

    @Autowired
    public BuddyRestController (BuddyInfoRepository buddyInfoRepository, AddressBookRepository addressBookRepository) {
        this.buddyInfoRepository = buddyInfoRepository;
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping(value = "/buddy", method = RequestMethod.GET)
    public BuddyInfo getBuddy(@RequestParam("bookId") Long addressBookID, @RequestParam ("buddyId") Integer buddyID) {
        AddressBook addressBook = addressBookRepository.findByID(addressBookID);
        return addressBook.getContactByID(buddyID-1);
    }

    @RequestMapping(value = "/buddy", method = RequestMethod.POST)
    public BuddyInfo addBuddy(@RequestParam String name, @RequestParam String phoneNumber) {
        AddressBook addressBook = addressBookRepository.findByID(1L);
        BuddyInfo bi = new BuddyInfo(name,phoneNumber);
        addressBook.addContact(bi);
        buddyInfoRepository.save(bi);
        addressBookRepository.save(addressBook);
        return bi;
    }

    @RequestMapping(value = "/buddy", method = RequestMethod.DELETE)
    public BuddyInfo deleteBuddy(@RequestParam("bookId") Long addressBookID,@RequestParam("buddyId") Integer buddyID) {
        AddressBook addressBook = addressBookRepository.findByID(addressBookID);
        BuddyInfo buddyInfo = addressBook.getContactByID(buddyID-1);
        addressBook.removeContact(Long.valueOf(buddyID-1));
        buddyInfoRepository.delete(buddyInfo);
        addressBookRepository.save(addressBook);
        return buddyInfo;
    }

}
