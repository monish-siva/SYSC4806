package PerkManager.Repositorys;

import PerkManager.Classes.ProductList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends CrudRepository<ProductList, Long> {
    ProductList findByID(long id);
}
