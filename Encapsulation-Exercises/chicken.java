import javax.swing.*;
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
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            Chicken chicken = new Chicken(name, age);
            System.out.println(chicken);


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age){
        setName(name);
        setAge(age);

    }

    private void setAge(int age) {
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }else{
            this.age = age;
        }
    }

    private void setName(String name) {
        if(name.isEmpty() || name.equals("null") || name.equals(" ")){
            throw new IllegalArgumentException("Name cannot be empty.");
        }else{
            this.name = name;
        }
    }

    public double productPerDay (){
        double result;
        if (this.age < 6) {
            result = 2;
        } else if (this.age < 12) {
            result = 1;
        } else {
            result = 0.75;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
    }
}
