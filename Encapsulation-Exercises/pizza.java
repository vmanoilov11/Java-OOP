import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        setName(name);
       setToppings(numberOfToppings);
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings >= 0 && numberOfToppings <= 10) {
            this.toppings = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length() > 15 ){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }else{
            this.name = name;
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
    }

    public String getName() {
        return name;
    }
    public double getOverallCalories (){
        double totalCalories = 0;
        for (Topping topping : this.toppings) {
            totalCalories += topping.calculateCalories();
        }
        totalCalories += dough.calculateCalories();
        return totalCalories;
    }
}

import java.util.ArrayDeque;
import java.util.Arrays;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public void setBakingTechnique(String bakingTechnique) {
        if(Arrays.stream(BankingTypes.values()).map(BankingTypes::toString).anyMatch(type -> type.equals(bakingTechnique.toLowerCase()))){
            this.bakingTechnique = bakingTechnique;
        } else {
        throw new IllegalArgumentException("Invalid type of dough.");
    }

    }

    public void setFlourType(String flourType) {
        if (Arrays.stream(FlourTypes.values()).map(FlourTypes::toString).anyMatch(type -> type.equals(flourType.toLowerCase()))) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }
    public double calculateCalories (){
        return (2 * this.weight) * FlourTypes.valueOf(this.flourType.toLowerCase()).getFlowerType() * BankingTypes.valueOf(this.bakingTechnique.toLowerCase()).getBankingType();

    }
}


//flourType: String
//bakingTechnique: String
//weight: double
//Dought (String, String, double)
//setWeight(double): void
//setFlourType(String): void
//setBakingTechnique(String): void
//calculateCalories (): double


import java.util.Arrays;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setWeight(double weight) {
        if(weight > 50 || weight < 1){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }else{
            this.weight = weight;
        }
    }

    public void setToppingType(String toppingType) {
        if(Arrays.stream(ToppingsTypes.values()).map(ToppingsTypes::toString).anyMatch(type -> type.equals(toppingType.toLowerCase()))){
            this.toppingType = toppingType;
        }else{
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }
    public double calculateCalories(){
        ToppingsTypes toppingsModifier = ToppingsTypes.valueOf(this.toppingType.toLowerCase());
        double modifier = toppingsModifier.getToppingsType();
        return (2 * this.weight) * modifier;

    }
}
//toppingType: String
//weight: double
//Topping (String, double)
//setToppingType (String): void
//setWeight (double): void
//calculateCalories (): double


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] pizzaInputData = scanner.nextLine().split("\\s+");

        try {
            String pizzaName = pizzaInputData[1];
            int numberOfToppings = Integer.parseInt(pizzaInputData[2]);

            Pizza myPizza = new Pizza(pizzaName, numberOfToppings);

            String[] doughInputData = scanner.nextLine().split("\\s+");
            String flourType = doughInputData[1];
            String bakingTechnique = doughInputData[2];
            double weightInGrams = Double.parseDouble(doughInputData[3]);

            Dough pizzaDough = new Dough(flourType, bakingTechnique, weightInGrams);

            myPizza.setDough(pizzaDough);

            String[] toppingInputData = scanner.nextLine().split("\\s+");
            while (!toppingInputData[0].equals("END")){
                String toppingType = toppingInputData[1];
                double toppingWeight = Double.parseDouble(toppingInputData[2]);

                Topping myCurrentTopping = new Topping(toppingType, toppingWeight);

                myPizza.addTopping(myCurrentTopping);

                toppingInputData = scanner.nextLine().split("\\s+");
            }
            System.out.printf("%s - %.2f%n", myPizza.getName(), myPizza.getOverallCalories());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
