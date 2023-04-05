package PerkManager.Repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import PerkManager.Classes.Perk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PerkRepository extends CrudRepository<Perk, Long> {
    Perk findByID(long id);
    @Query (value = "select * from perk p where p.perk_name like %:keyword% or p.perk_location like %keyword%", nativeQuery = true)
    List<Perk> findByKeyword(@Param("keyword") String keyword);
   // @Query(value = "select * from shop s where s.owner_name like %:keyword% or s.shop_type like %:keyword%", nativeQuery = true)

}
