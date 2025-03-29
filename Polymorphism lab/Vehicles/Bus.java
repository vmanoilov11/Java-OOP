package Vehicles;

public class Bus extends Vehicle{
    public Bus(Double fuelQuantity, Double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    boolean drive(Double distance) {
        if(distance * (super.fuelConsumption) + 1.4 <= super.fuelQuantity){
            super.fuelQuantity -= distance * (super.fuelConsumption + 1.4);
            return true;
        }
        return false;

    }
    public boolean driveEmpty(Double distance) {
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

    @Override
    public Double getFuelConsumption() {
        return super.getFuelConsumption();
    }

    @Override
    public Double getFuelQuantity() {
        return super.getFuelQuantity();
    }
}
