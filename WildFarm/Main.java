package WildFarm;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("#.##");

        String input;
        while (!(input = scanner.nextLine()).equals("End")) {
            String[] animalInfo = input.split(" ");
            Animal animal = null;

            switch (animalInfo[0]) {
                case "Cat":
                    animal = new Cat(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3], animalInfo[4]);
                    break;
                case "Mouse":
                    animal = new Mouse(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    break;
                case "Tiger":
                    animal = new Tiger(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(animalInfo[1], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    break;
            }

            if (animal != null) {
                animals.add(animal);
                animal.makeSound();
            }

            String[] foodInfo = scanner.nextLine().split(" ");
            int foodQuantity = Integer.parseInt(foodInfo[1]);
            if (foodInfo[0].equals("Vegetable")) {
                Vegetable vegetable = new Vegetable(foodQuantity);
                if (animal instanceof Zebra || animal instanceof Mouse || animal instanceof Cat) {
                    animal.eatFood(foodQuantity);
                } else {
                    System.out.println("Tigers are not eating that type of food!");
                }
            } else {
                Meat meat = new Meat(foodQuantity);
                if (animal instanceof Tiger || animal instanceof Cat) {
                    animal.eatFood(foodQuantity);
                } else {
                    System.out.printf("%s is not eating that type of food!", animal.getAnimalType());
                }
            }

            System.out.println(animal);
        }
    }
}