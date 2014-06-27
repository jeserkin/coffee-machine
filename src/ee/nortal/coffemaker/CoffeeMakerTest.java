package ee.nortal.coffemaker;

import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        coffeeMaker = new CoffeeMaker();
    }

    private void createMany(int n) {
        for (int i = 0; i < n; i++) {
            coffeeMaker.makeBlackCoffee();
        }
    }

    @Test(expected = RuntimeException.class)
    public void createMaxBlackCoffee() {
        createMany(8);
    }
}
