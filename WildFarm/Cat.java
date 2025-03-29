package WildFarm;


import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;
    DecimalFormat df = new DecimalFormat("#.##");

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super("Cat", animalName, animalWeight, livingRegion); // Set animalType to "Cat"
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(int food) {
        setFoodEaten(getFoodEaten() + food);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), getBreed(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());

    }

}