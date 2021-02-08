package slash.code.dealer.cards;


import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


@Component
public class Deck {

    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    private ArrayList<Card> cards;
    Integer count = 0;
    Integer turns = 0;
    private ArrayList<Card> usedCard;
    StringBuffer sb = new StringBuffer();

    public Deck() {
        this.cards = new ArrayList<Card>();
        this.cards = initPokerDeck(cards);
        usedCard = new ArrayList<>();
        shuffleCard(1);


    }

    private ArrayList<Card> initPokerDeck(ArrayList<Card> card) {
        if (card.isEmpty()) {
            count = 0;

            CardData baseCards = new CardData();
            for (String color : baseCards.color
            ) {
                for (Integer values : baseCards.value
                ) {
                    if (values == 1) {
                        Card ace = new Card(color, 10, baseCards.faceValue[4], "Ace");

                        card.add(ace);
                        count += 1;
                    } else {
                        Card card1 = new Card(color, values, baseCards.faceValue[0], baseCards.description[0]);
                        card.add(card1);
                        count += 1;
                    }
                }
                for (int i = 1; i < 4; i++) {

                    Card faceCard = new Card(color, 10, baseCards.faceValue[i], baseCards.description[i]);
                    card.add(faceCard);
                    count += 1;

                }

            }
            if (count == 52) {
                System.out.println("Deck is full");
            }
        }
        return card;

    }

    public void shuffleCard(int x) {
        for (int i = 0; i < x; i++) {
            Collections.shuffle(cards);
        }

    }

    public Card getOneCardFromDeck() {
        Card randomCard = this.cards.get(0);

        cards.remove(0);
        return randomCard;
    }


    public ArrayList<Card> getCards() {
        return cards;
    }

    private void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    private class CardData {
        final String[] color = {"Diamond", "Spade", "Heart", "Club"};
        final Integer[] value = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final Integer[] faceValue = {0, 1, 2, 3, 4};
        final String[] description = {"", "Jack", "Queen", "King"};

        public CardData() {
        }
    }


    public String riverFill() {
        Card cardA = this.getCards().get(0);
        sb.append(cardA.value + "//" + cardA.color + "//" + cardA.description + "//" + cardA.faceVal + "//£//");
        this.usedCard.add(cardA);
        this.cards.remove(cardA);
        return sb.toString();
    }


    @Override
    public String toString() {
        for (Card card : this.cards) {
            System.out.println(card.toString());
        }
        return "deck has " + this.count + " cards";
    }
}

