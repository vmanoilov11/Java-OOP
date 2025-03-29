package WildFarm;

public abstract class Animal {
    private String animalType; // Added back the animalType field
    private String animalName;
    private Double animalWeight;
    private Integer foodEaten;

    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    public abstract void makeSound();
    public abstract void eatFood(int food);

    public String getAnimalName() {
        return animalName;
    }

    public String getAnimalType() {
        return animalType; // Getter for animalType
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    @Override
    public abstract String toString();
}