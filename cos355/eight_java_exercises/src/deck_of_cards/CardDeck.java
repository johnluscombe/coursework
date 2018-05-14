package deck_of_cards;

import java.util.ArrayList;
import java.util.Random;

public class CardDeck {
    private ArrayList<Card> cardDeck;
    private static final Random random = new Random();

    public CardDeck() {
        createCardDeck(false);
    }

    public CardDeck(boolean includeJokers) {
        createCardDeck(includeJokers);
    }

    public void shuffleDeck() {
        Card tempCard;
        int swapIdx;

        for (int i = 0; i < cardDeck.size(); i++) {
            swapIdx = random.nextInt(cardDeck.size());
            if (i != swapIdx) {
                tempCard = cardDeck.get(i);
                cardDeck.set(i, cardDeck.get(swapIdx));
                cardDeck.set(swapIdx, tempCard);
            }
        }
    }

    public Card drawCard() {
        return cardDeck.remove(cardDeck.size() - 1);
    }

    public String toString() {
        StringBuilder cardDeckString = new StringBuilder();

        for (Card card : cardDeck) {
            cardDeckString.append(card.toString());
            cardDeckString.append(" ");
        }

        return cardDeckString.toString();
    }

    private void createCardDeck(boolean includeJokers) {
        if (includeJokers) {
            cardDeck = new ArrayList<>();
            addJokersToDeck();
            addCardsToDeck();
        } else {
            cardDeck = new ArrayList<>();
            addCardsToDeck();
        }
    }

    private void addJokersToDeck() {
        Card card;

        for (int i = 0; i < 4; i++) {
            card = new Card("JOKER");
            cardDeck.add(card);
        }
    }

    private void addCardsToDeck() {
        String rank;
        Card card;

        for (int rankNumber=1; rankNumber < 14; rankNumber++) {
            rank = Card.convertNumberToRank(rankNumber);
            for (Suit suit : Suit.values()) {
                card = new Card(rank, suit);
                cardDeck.add(card);
            }
        }
    }

    public static void main(String[] args) {
        CardDeck cardDeck1 = new CardDeck();
        System.out.println(cardDeck1.toString());
        cardDeck1.shuffleDeck();
        System.out.println(cardDeck1.toString());
        Card card = cardDeck1.drawCard();
        System.out.println(card);
        System.out.println(cardDeck1.toString());
    }
}
