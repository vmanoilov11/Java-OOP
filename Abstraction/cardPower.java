public class Card {
    private Suits suit;
    private Ranks rank;
    private int power;

    public Card(Suits suit, Ranks rank){
        this.suit = suit;
        this.rank = rank;
        this.power = this.suit.getValue() + this.rank.getValue();
    }

    public int getPower() {
        return power;
    }

    public Ranks getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }
}


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card myCard = new Card(Suits.valueOf(suit), Ranks.valueOf(rank));
        System.out.printf("Card name: %s of %s; Card power: %d%n", myCard.getRank(), myCard.getSuit(), myCard.getPower());
    }

}

import javax.smartcardio.Card;

public enum Ranks {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private int value;
    Ranks(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public enum Suits {

    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private final int value;

    Suits(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
