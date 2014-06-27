package ee.nortal.coffemaker;

class CoffeeMaker {
    private static final int MAX_WATER_CAPACITY = 600;
    private static final int MAX_BEAN_CONTAINER_CAPACITY = 400;
    private static final int MAX_GARBAGE_CONTAINER_CAPACITY = 400;
    private int waterCapacity = MAX_WATER_CAPACITY;
    private int beanContainerCapacity = MAX_BEAN_CONTAINER_CAPACITY;
    private int garbageContainerCapacity = MAX_GARBAGE_CONTAINER_CAPACITY;

    public void makeBlackCoffee() {
        if (isGarbageFull(50)) {
            throw new RuntimeException("Not enough space in garbage container");
        }
        if (checkWater(150)) {
            throw new RuntimeException("Not enough water");
        }
        if (checkBeans(50)) {
            throw new RuntimeException("Not enough beans");
        }
        useWater(150);
        useBeans(50);
    }

    private void useWater(int amount) {
        waterCapacity -= amount;
    }

    private boolean checkWater(int amount) {
        return waterCapacity < amount;
    }

    private void useBeans(int amount) {
        beanContainerCapacity -= amount;
        putGarbage(amount);
    }

    private boolean checkBeans(int amount) {
        return beanContainerCapacity < amount;
    }

    private void putGarbage(int amount) {
        garbageContainerCapacity -= amount;
    }

    public void refillWater() {
        waterCapacity = MAX_WATER_CAPACITY;
    }

    public void refillBeans() {
        beanContainerCapacity = MAX_BEAN_CONTAINER_CAPACITY;
    }

    public void emptyGarbage() {
        garbageContainerCapacity = MAX_GARBAGE_CONTAINER_CAPACITY;
    }

    private boolean isGarbageFull(int amount) {
        return garbageContainerCapacity < amount;
    }
}
