import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Birthable> birthables = new ArrayList<>();

        while (!input.equals("End")){
            String[] parts = input.split(" ");
            if(parts[0].equals("Citizen")){
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String id = parts[3];
                String birthDate = parts[4];
                birthables.add(new Citizen(name, age, id, birthDate));

            }else if(parts[0].equals("Pet")){
                String name = parts[1];
                String birthDate = parts[2];
                birthables.add(new Pet(name, birthDate));


            }else if(parts[0].equals("Robot")){
                String model = parts[1];
                String id = parts[2];
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable b : birthables) {
            if (b.getBirthDate().endsWith(year)) {
                System.out.println(b.getBirthDate());
            }
        }
    }

}