package edu.guilford;

import java.util.Random;

public class Card {

    public static String[] RANKS = {
            "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

    public static String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades" };

    private int rank;
    private int suit;
    private Random rand = new Random();

    public Card() {
        this.rank = rand.nextInt(RANKS.length);
        this.suit = rand.nextInt(SUITS.length);
    }

    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuit() {
        return this.suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public boolean equals(Card that) {
        return this.rank == that.rank
                && this.suit == that.suit;
    }

    public int compareTo(Card that) {
        if (this.suit < that.suit) {
            return -1;
        }
        if (this.suit > that.suit) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return 0;
    }

    public boolean isFaceCard() {
        boolean face = false;

        if (rank > 9 || rank == 0) {
            face = true;
        }

        return face;
    }

    @Override
    public String toString() {
        return RANKS[this.rank] + " of " + SUITS[this.suit];
    }
}
