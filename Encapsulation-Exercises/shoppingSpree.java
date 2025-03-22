import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product){
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        } else {
            products.add(product);
            this.money -= product.getCost();
        }
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = money;
        }
    }

    public String getName() {
        return name;
    }
    public int getBagSize(){
        return this.products.size();
    }
    public List<String> getProducts(){
        return this.products.stream().map(Product::toString).collect(Collectors.toList());
    }

}

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost){
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setCost(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.cost = money;
        }
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }


}


import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] peopleInput = scanner.nextLine().split(";");
        String[] productsInput = scanner.nextLine().split(";");
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        try{

            for(String person : peopleInput){
                String[] elements = person.split("=");
                String name = elements[0];
                double money = Double.parseDouble(elements[1]);
                people.add(new Person(name, money));
            }
            for(String product : productsInput){
                String[] elements = product.split("=");
                String name = elements[0];
                double cost = Double.parseDouble(elements[1]);
                products.add(new Product(name, cost));
            }

            String data = scanner.nextLine();
            while (!data.equals("END")){
                String[] elements = data.split(" ");
                String name = elements[0];
                String product = elements[1];
                for (Person person : people) {
                    if(person.getName().equals(name)){
                        for(Product product1 : products){
                            if(product1.getName().equals(product)){
                                person.buyProduct(product1);
                                System.out.println(person.getName() + " bought " + product1.getName() + " ");
                            }
                        }
                    }
                }

                data = scanner.nextLine();
            }


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        for (Person person : people) {
            if (person.getBagSize() == 0) {
                System.out.println(person.getName() + " - " + "Nothing bought");
                continue;
            }
            System.out.println(person.getName() + " - " + String.join(", ", person.getProducts()));
        }
    }
}
//Peter=11;George=4
//Bread=10;Milk=2
//Peter Bread
//George Milk
//George Milk
//Peter Milk
//END
