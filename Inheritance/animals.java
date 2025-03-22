public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender){
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || !Character.isLetter(name.charAt(0))) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age <= 0){
            throw new IllegalArgumentException("Invalid input!");
        }
            this.age = age;
    }

    public void setGender(String gender) {
        if (gender.equals("Male") || gender.equals("Female")) {
            this.gender = gender;
        }else{
            throw new IllegalArgumentException("Invalid input!");
        }

    }    public String toString() {
        return this.getClass().getSimpleName() + System.lineSeparator() +
                this.name + " " + this.age + " " + this.gender + System.lineSeparator() +
                this.produceSound();
    }

    public String produceSound(){
        return "";
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> animals = new ArrayList<>();


        while (!input.equals("Beast!")){
            if(input.equals("Dog")){
                String[] data = scanner.nextLine().split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];
                Dog dog = new Dog(name, age, gender);
                System.out.println(dog.toString());

            }else if(input.equals("Cat")){
                String[] data = scanner.nextLine().split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];
                if(gender.equals("Male") || gender.equals("Female")){
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat.toString());
                }else if(gender.equals("Kitten")){
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten.toString());

                }else if(gender.equals("Tomcat")){
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat.toString());
                }


            }else if(input.equals("Frog")){
                String[] data = scanner.nextLine().split(" ");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String gender = data[2];
                Frog frog = new Frog(name, age, gender);
                System.out.println(frog.toString());
            }

            input = scanner.nextLine();
        }



    }
}
public class Dog extends Animal{
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }
    public String produceSound() {
        return "Woof!";
    }
}
public class Cat extends Animal{
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }
    public String produceSound() {
        return "Meow Meow";
    }
}
public class Frog extends Animal{
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Ribbit";
    }
}
public class Tomcat extends Cat {

    private final static String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}public class Kitten extends Cat {

    private final static String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
