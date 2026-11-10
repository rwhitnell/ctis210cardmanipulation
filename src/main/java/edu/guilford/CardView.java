package edu.guilford;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class CardView extends JLabel {
    private int suit;
    private int value;

    public CardView(int suit, int value, Image image) {
        this.suit = suit;
        this.value = value;
        setIcon(new ImageIcon(image));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Card clicked: " + getRank() + getSuitString());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                setLocation(e.getX() + getX() - getWidth() / 2, e.getY() + getY() - getHeight() / 2);
            }
        });
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private String getRank() {
        String rank = "";
        switch (value) {
            case 0 -> rank = "A";
            case 1 -> rank = "2";
            case 2 -> rank = "3";
            case 3 -> rank = "4";
            case 4 -> rank = "5";
            case 5 -> rank = "6";
            case 6 -> rank = "7";
            case 7 -> rank = "8";
            case 8 -> rank = "9";
            case 9 -> rank = "10";
            case 10 -> rank = "J";
            case 11 -> rank = "Q";
            case 12 -> rank = "K";
        }
        return rank;
       
    }

    private String getSuitString() {
        String suitString = "";
        switch (suit) {
            case 0 -> suitString = "c";
            case 1 -> suitString = "d";
            case 2 -> suitString = "h";
            case 3 -> suitString = "s";
        }   

        return suitString;
    
    }
}
