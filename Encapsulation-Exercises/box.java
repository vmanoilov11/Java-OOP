import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        try{
            Scanner scanner = new Scanner(System.in);
            double length = Double.parseDouble(scanner.nextLine());
            double width = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());

            Box box = new Box(length, width, height);
            System.out.println("Surface Area - " + box.calculateSurfaceArea());
            System.out.println("Lateral Surface Area - " + box.calculateLateralSurfaceArea());
            System.out.println("Volume - " + box.calculateVolume());


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
public class Box {
    private  double length;
    private  double width;
    private  double height;

    public Box(double length, double width, double height){
        setLength(length);
        setWidth(width);
        setHeight(height);
    }


    public double calculateSurfaceArea(){
        //2lw + 2lh + 2wh
        return 2 * this.length * this.width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        //2lh + 2wh
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        //lwh
        return this.length * this.width * this.height;
    }


    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }else{
            this.height = height;
        }
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }else{
            this.width = width;
        }
    }

    private void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }else{
            this.length = length;
        }
    }

}
