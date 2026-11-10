package edu.guilford;

import javax.swing.JFrame;

public class CardManipulation {
    public static void main(String[] args) {
        CardPanel cardPanel = new CardPanel(800, 300);
        JFrame frame = new JFrame("Card Manipulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cardPanel);
        frame.pack();
        frame.setVisible(true);
    }
}