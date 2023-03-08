package PerkManager.Classes;
import PerkManager.Classes.PerkSources.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import PerkManager.Classes.PerkSources.Membership;
import PerkManager.Classes.PerkSources.Card;

@Entity
@Table(name = "user_perks")
public class Perk {

    @Id
    @GeneratedValue
    private Long ID;

    private String location;
    private String card;

    private String membership;

    /**
     * Default constructor
     */
    protected Perk(){
        this.ID = null;
        this.location = "";
        this.card = "";
        this.membership = "";
    }

    public Perk(String location, String card, String membership){
        this();
        this.location = location;
        this.card = card;
        this.membership = membership;
    }

    public String getLocation(){
        return this.location;
    }

    public String getCard(){
        return this.card;
    }

    public String getMembership(){
        return this.membership;
    }

    public Long getID(){
        return this.ID;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
