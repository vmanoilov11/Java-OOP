import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + ":");
        for(Suits suit : Suits.values()){
            System.out.println("Ordinal value: " + suit.ordinal() + " Name value: " + suit);

        }
    }

}
public enum Suits {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}
