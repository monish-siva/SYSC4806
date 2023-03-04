package anthonymp.SYSC4806_Lab3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookRestController {
    private AddressBookRepository addressBookRepository;


    @Autowired
    public AddressBookRestController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @RequestMapping("/addressBook")
    public AddressBook createAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @RequestMapping(value = "/addressBook", method = RequestMethod.GET)
    public AddressBook getAddressBook(@RequestParam("id") Long id){
        return addressBookRepository.findByID(id);
    }
}