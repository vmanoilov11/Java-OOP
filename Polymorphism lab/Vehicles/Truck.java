package Vehicles;

public class Truck extends Vehicle{

    public Truck(Double fuelQuantity, Double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
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
            super.fuelQuantity += liters * 0.95;
        }
    }

}
