package anthonymp.SYSC4806_Lab3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    //List<AddressBook> findAddressBook(String name);
    AddressBook findByID(long id);
}
