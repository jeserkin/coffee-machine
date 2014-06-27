package ee.nortal.coffemaker;

import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {

    private CoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        coffeeMaker = new CoffeeMaker();
    }

    @Test(expected = RuntimeException.class)
    public void createMaxBlackCoffee() {
        createMany(8);
    }

    @Test
    public void createRefillWater() {
        createMany(3);
        coffeeMaker.refillWater();
        createMany(3);
    }

    @Test(expected = RuntimeException.class)
    public void createRefillWaterAndBeans() {
        for (int i = 0; i < 3; i++) {
            createMany(3);
            coffeeMaker.refillWater();
            coffeeMaker.refillBeans();
        }
    }

    @Test
    public void checkError() {
        createMany(4);
        coffeeMaker.refillWater();
        createMany(4);
        coffeeMaker.refillWater();
        coffeeMaker.refillBeans();
        try {
            createMany(4);
        } catch (RuntimeException ignored) {}
        coffeeMaker.emptyGarbage();
        createMany(4);
    }

    private void createMany(int n) {
        for (int i = 0; i < n; i++) {
            coffeeMaker.makeBlackCoffee();
        }
    }
}
