package ee.nortal.coffemaker;

class CoffeeMaker {
    private int waterCapacity = 600;
    private int beanContainerCapacity = 400;

    public void makeBlackCoffee() {
        useWater();
        useBeans();
    }

    private void useBeans() {
        if (beanContainerCapacity < 50) {
            throw new RuntimeException("Not enough beans");
        }
        beanContainerCapacity -= 50;
    }

    private void useWater() {
        if (waterCapacity < 150) {
            throw new RuntimeException("Not enough water");
        }
        waterCapacity -= 150;
    }
}
