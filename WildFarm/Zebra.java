package WildFarm;

import java.text.DecimalFormat;

public class Zebra extends Mammal {
    DecimalFormat df = new DecimalFormat("#.##");

    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super("Zebra", animalName, animalWeight, livingRegion); // Set animalType to "Zebra"
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eatFood(int food) {
        setFoodEaten(getFoodEaten() + food);
    }
    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]",
                getAnimalType(),
                getAnimalName(),
                df.format(getAnimalWeight()),
                getLivingRegion(),
                getFoodEaten());
    }
}
