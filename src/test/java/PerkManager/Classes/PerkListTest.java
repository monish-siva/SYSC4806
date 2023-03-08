package PerkManager.Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PerkListTest {

    @Test
    void checkPerkList() {
        PerkList pList = new PerkList();
        Perk perk1 = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        Perk perk2 = new Perk("quebec", "TDCashBackCreditCard", "", "2.5% on tech");
        List<Perk> perks = new ArrayList<>();
        assertEquals(perks, pList.getPerks());
        pList.addPerk(perk1);
        perks.add(perk1);
        assertEquals(perks, pList.getPerks());
        pList.addPerk(perk2);
        perks.add(perk2);
        assertEquals(perks, pList.getPerks());
    }

    @Test
    void getID() {
        PerkList perkList = new PerkList((long)22);
        assertEquals(22, perkList.getID());
    }

    @Test
    void setID() {
        PerkList perkList = new PerkList();
        perkList.setID((long)22);
        assertEquals(22, perkList.getID());
    }

    @Test
    void getPerksByID() {
        PerkList perkList = new PerkList();
        Perk perk1 = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        Perk perk2 = new Perk("quebec", "TDCashBackCreditCard", "", "2.5% on tech");
        perkList.addPerk(perk1);
        perkList.addPerk(perk2);
        assertEquals(perk1, perkList.getPerkByID((long)0));
        assertEquals(perk2, perkList.getPerkByID((long)1));
    }

}
