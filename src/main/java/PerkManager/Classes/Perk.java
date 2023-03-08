package PerkManager.Classes;
import PerkManager.Classes.PerkSources.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_perks")
public class Perk {

    @Id
    @GeneratedValue
    private Long ID;

    public  Perk(){

    }
}
