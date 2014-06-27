package ee.nortal.coffemaker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeMakerTest {
    private CoffeeMaker coffeeMaker = new CoffeeMaker();

    @Test
    public void createBlackCoffee() {
        String coffee = coffeeMaker.makeBlackCoffee();
        assertEquals("black coffee", coffee);
    }
}
