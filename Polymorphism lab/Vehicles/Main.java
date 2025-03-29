package Vehicles;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        String[] carInfo = scanner.nextLine().split(" ");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Integer.parseInt(carInfo[3]));

        String[] truckInfo = scanner.nextLine().split(" ");
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Integer.parseInt(truckInfo[3]));

        String[] busInfo = scanner.nextLine().split(" ");
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Integer.parseInt(busInfo[3]));

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String command = input[0];
            String vehicleType = input[1];
            if (command.equals("Drive")) {
                double distance = Double.parseDouble(input[2]);
                if (vehicleType.equals("Car")) {
                    if (car.drive(distance)) {
                        System.out.println("Car travelled " + df.format(distance) + " km");
                    } else {
                        System.out.println("Car needs refueling");
                    }
                }
                else if (vehicleType.equals("Truck")) {
                    if (truck.drive(distance)) {
                        System.out.println("Truck travelled " + df.format(distance) + " km");
                    } else {
                        System.out.println("Truck needs refueling");
                    }
                }
                else if (vehicleType.equals("Bus")) {
                    if (bus.drive(distance)) {
                        System.out.println("Bus travelled " + df.format(distance) + " km");
                    } else {
                        System.out.println("Bus needs refueling");
                    }
                }
            }else if(command.equals("DriveEmpty")){
                double distance = Double.parseDouble(input[2]);
                if(bus.driveEmpty(distance)){
                    System.out.println("Bus travelled " + df.format(distance) + " km");
                }else{
                    System.out.println("Bus needs refueling");
                }

            }
            else if(command.equals("Refuel")) {
                Double liters = Double.parseDouble(input[2]);
                if (vehicleType.equals("Car")) {
                    car.refuel(liters);
                } else if (vehicleType.equals("Truck")) {
                    truck.refuel(liters);
                }else if(vehicleType.equals("Bus")){
                    bus.refuel(liters);
                }
            }
        }
        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f\n", bus.getFuelQuantity());


    }
}
