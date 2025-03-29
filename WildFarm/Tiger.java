package WildFarm;

import java.text.DecimalFormat;

public class Tiger extends Felime {
    private static final DecimalFormat df = new DecimalFormat("#.##"); // Static final for better performance

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super("Tiger", animalName, animalWeight, livingRegion); // Set animalType to "Tiger"
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
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