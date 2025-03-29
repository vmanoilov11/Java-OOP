package WildFarm;

import java.text.DecimalFormat;

public class Mouse extends Mammal {
    DecimalFormat df = new DecimalFormat("#.##");

    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super("Mouse", animalName, animalWeight, livingRegion); // Set animalType to "Mouse"
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
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
