import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input + ":");
        for(Ranks rank : Ranks.values()){
            System.out.println("Ordinal value: " + rank.ordinal() + " Name value: " + rank);

        }
    }

}

/*Card RanksA
*/

public enum Ranks {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}
