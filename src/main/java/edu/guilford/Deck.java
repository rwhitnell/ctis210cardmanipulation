package edu.guilford;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (int i = 0; i < Card.SUITS.length; i++) {
            for (int j = 0; j < Card.RANKS.length; j++) {
                deck.add(new Card(j, i));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public Card dealCard() {
        if (deck.size() > 0) {
            return deck.remove(0);
        } else {
            return null;
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : deck) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }
}
