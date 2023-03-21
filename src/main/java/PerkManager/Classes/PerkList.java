package PerkManager.Classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perk_list")
public class PerkList {


    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List <Perk> perks;

    @Id
    @GeneratedValue
    private Long ID;

    public PerkList () {

        this.perks = new ArrayList<Perk>();
    }

    public PerkList(Long id) {
        this.setID(id);
        this.perks = new ArrayList<Perk>();
    }

    public void addPerk(Perk perk) {
        this.perks.add(perk);
    }

    public List<Perk> getPerks(){
        return this.perks;
    }

    public long getID(){
        return this.ID;
    }

    public int getPerkListLength() { return this.perks.size();}

    public Perk getPerkByID(Long id){
        return this.perks.get(Math.toIntExact(id));
    }

    public void setID(Long id) {
        this.ID = id;
    }

}
