package deck_of_cards;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

enum Suit { CLUB, DIAMOND, HEART, SPADE }

public class Card {
    private final String rank;
    private final Suit suit;
    private static final Random random = new Random();
    private static final int randomNumberForRank = random.nextInt(13) + 1;
    private static final int randomNumberForSuit = random.nextInt(4);

    public Card() {
        rank = convertNumberToRank(randomNumberForRank);
        suit = Suit.values()[randomNumberForSuit];
    }

    public Card(String rank) {
        if (!isValidRank(rank)) {
            throwRankException(rank);
        }

        this.rank = rank;

        if (!rank.equals("JOKER")) {
            suit = Suit.values()[randomNumberForSuit];
        } else {
            suit = null;
        }
    }

    public Card(Suit suit) {
        this.suit = suit;
        rank = convertNumberToRank(randomNumberForRank);
    }

    public Card(String rank, Suit suit) {
        if (!isValidRank(rank)) {
            throwRankException(rank);
        }

        this.rank = rank;

        if (!rank.equals("JOKER")) {
            this.suit = suit;
        } else {
            this.suit = null;
        }
    }

    public String toString() {
        return rank + suitSymbol(suit);
    }

    public static String convertNumberToRank(int number) {
        String rank;

        if (number == 1) {
            rank = "A";
        } else if (number == 11) {
            rank = "J";
        } else if (number == 12) {
            rank = "Q";
        } else if (number == 13) {
            rank = "K";
        } else {
            rank = Integer.toString(number);
            if (number < 1 || number > 13) {
                throwRankException(rank);
            }
        }

        return rank;
    }

    public static String suitSymbol(Suit suit) {
        if (suit == Suit.CLUB) {
            return "\u2663";
        } else if (suit == Suit.DIAMOND) {
            return "\u2666";
        } else if (suit == Suit.HEART) {
            return "\u2665";
        } else if (suit == Suit.SPADE) {
            return "\u2660";
        } else {
            return "";
        }
    }

    private static boolean isValidRank(String rank) {
        List<String> validRanks = Arrays.asList(
                "A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "JOKER"
        );

        return validRanks.contains(rank);
    }

    private static void throwRankException(String rank) {
        throw new IllegalArgumentException(String.format("Rank '%s' is not valid", rank));
    }

    public static void main(String[] args) {
        Card card1 = new Card();
        System.out.println(card1.toString());

        Card card2 = new Card(Suit.CLUB);
        System.out.println(card2.toString());

        Card card3 = new Card("3");
        System.out.println(card3.toString());

        Card card4 = new Card("6", Suit.DIAMOND);
        System.out.println(card4.toString());

        Card card5 = new Card("JOKER");
        System.out.println(card5.toString());

        Card card6 = new Card("JOKER", Suit.HEART);
        System.out.println(card6.toString());

        System.out.println(Card.convertNumberToRank(1));
        System.out.println(Card.convertNumberToRank(2));
        System.out.println(Card.convertNumberToRank(11));
        System.out.println(Card.convertNumberToRank(12));
        System.out.println(Card.convertNumberToRank(13));
//        System.out.println(Card.convertNumberToRank(0));
//        System.out.println(Card.convertNumberToRank(14));

//        new Card("B");
//        new Card("C", Suit.HEART);
    }
}