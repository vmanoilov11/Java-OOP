package Vehicles;

public abstract class Vehicle {
    protected Double fuelQuantity;
    protected Double fuelConsumption;
    protected int tankCapacity;

    public Vehicle(Double fuelQuantity, Double fuelConsumption, int tankCapacity){
        this.fuelConsumption = fuelConsumption;
        this.fuelQuantity = fuelQuantity;
        this.tankCapacity = tankCapacity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }
    abstract boolean drive(Double distance);
    abstract void refuel(Double liters);

    protected String checkQuantity(Double liters){
        if (liters <= 0) {
            return "Fuel must be a positive number";
        }
        if (liters + fuelQuantity > this.tankCapacity) {
            return "Cannot fit fuel in tank";
        }
        return null;
    }
}
