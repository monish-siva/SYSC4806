package PerkManager.Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    //test the getName method
    @Test
    void getName() {
        Product product = new Product("iPhone 14");
        assertEquals("iPhone 14", product.getName());
    }

    //test the setName method
    @Test
    void setName() {
        Product product = new Product("iPhone 14");
        product.setName("iPhone 14");
        assertEquals("iPhone 14", product.getName());
    }

    //test the addPerk, removePerk and contains methods
    @Test
    void testPerks() {
        Product product = new Product("iPhone 14");
        Perk perk1 = new Perk("ontario", "AmazonCreditCard", "AmazonPrime", "10% on Movies");
        Perk perk2 = new Perk("quebec", "TDCashBackCreditCard", "", "2.5% on tech");
        assertEquals(false, product.containsPerk(perk1));
        assertEquals(false, product.containsPerk(perk2));
        product.addPerk(perk1);
        assertEquals(true, product.containsPerk(perk1));
        assertEquals(false, product.containsPerk(perk2));
        product.addPerk(perk2);
        assertEquals(true, product.containsPerk(perk1));
        assertEquals(true, product.containsPerk(perk2));
        product.removePerk(perk1);
        assertEquals(false, product.containsPerk(perk1));
        assertEquals(true, product.containsPerk(perk2));
        product.removePerk(perk2);
        assertEquals(false, product.containsPerk(perk1));
        assertEquals(false, product.containsPerk(perk2));
    }

    //test the setID and getID methods
    @Test
    void setIDAndGetID() {
        Product product = new Product();
        assertEquals(null, product.getID());
        product.setID((long) 123);
        assertEquals((long)123, product.getID());
    }
}