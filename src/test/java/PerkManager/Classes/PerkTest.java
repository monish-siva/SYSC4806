package PerkManager.Classes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PerkTest {

    @Test
    public void createPerk(){
        Perk perk = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        assertNotEquals(null, perk);
    }

    @Test
    public void getLocation(){
        Perk perk = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        assertEquals("ontario", perk.getLocation());
    }

    @Test
    public void getCard(){
        Perk perk = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        assertEquals("AmazonCreditCard", perk.getCard());
    }

    @Test
    public void getMembership(){
        Perk perk = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        assertEquals("AmazonPrime", perk.getMembership());
    }
    @Test
    public void getDiscount(){
        Perk perk = new Perk("ontario", "AmazonCreditCard", "AmazonPrime","10% off on movies");
        assertEquals("10% off on movies", perk.getDiscount());
    }

    @Test
    public void setLocation(){
        Perk perk = new Perk();
        perk.setLocation("ontario");
        assertEquals("ontario", perk.getLocation());
    }

    @Test
    public void setCard(){
        Perk perk = new Perk();
        perk.setCard("AmazonCreditCard");
        assertEquals("AmazonCreditCard", perk.getCard());
    }

    @Test
    public void setMembership(){
        Perk perk = new Perk();
        perk.setMembership("AmazonPrime");
        assertEquals("AmazonPrime", perk.getMembership());
    }

    @Test
    public void setDiscount(){
        Perk perk = new Perk();
        perk.setDiscount("10% off on movies");
        assertEquals("10% off on movies", perk.getDiscount());
    }

}
