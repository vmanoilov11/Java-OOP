package Vehicles;

public class Car extends Vehicle{

    public Car(Double fuelQuantity, Double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + 0.9, tankCapacity);
    }

    @Override
    boolean drive(Double distance) {
        if(distance * super.fuelConsumption <= super.fuelQuantity){
            super.fuelQuantity -= distance * super.fuelConsumption;
            return true;
        }
        return false;
    }

    @Override
    void refuel(Double liters) {
        String validationMessage = checkQuantity(liters);
        if (validationMessage != null) {
            System.out.println(validationMessage);
        }else{
            super.fuelQuantity += liters;
        }

    }

}
