package edu.guilford;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CardPanel extends JPanel {
    private ArrayList<CardView> cardImages;
    private ArrayList<Card> cards;
    private Deck deck;
    private JButton generateButton;
    private int nCards = 8;

    private final int imageWidth = 75;

    public CardPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        generateButton = new JButton("Generate Hand");
        add(generateButton);
        generateButton.addActionListener(e -> {
            generateHand();
            System.out.println(e);
        });

        
        deck = new Deck();
        deck.shuffle();
        cards = new ArrayList<Card>();
    }

    public void generateHand() {
         
        if (cardImages == null) {
            cardImages = new ArrayList<CardView>();
        }

        removeAll();
        add(generateButton);

        int iCard = 0;

        cards.clear();

        if (deck.getDeck().size() < nCards) {
            deck = new Deck();
            deck.shuffle();
        }

        while (iCard < nCards) {
            Card nextCard = deck.dealCard();
            cards.add(nextCard);
            iCard++;
        }

        cardImages.clear();

        for (Card card : cards) {
            int rank = card.getRank();
            int suit = card.getSuit();
            String fileName = "src/cards/" + getName(card.getRank(), card.getSuit()) + ".png";
            BufferedImage tempImage = null;
            try {
                tempImage = javax.imageio.ImageIO.read(new File(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            tempImage = rescaleImage(tempImage);
            CardView tempView = new CardView(suit, rank, tempImage);
            cardImages.add(tempView);
            add(tempView);
        }
      
        revalidate();
        repaint();

    }

    public String getName(int rank, int suit) {
        String name = "";
        switch (rank) {
            case 0 -> name += "a";
            case 1 -> name += "2";
            case 2 -> name += "3";
            case 3 -> name += "4";
            case 4 -> name += "5";
            case 5 -> name += "6";
            case 6 -> name += "7";
            case 7 -> name += "8";
            case 8 -> name += "9";
            case 9 -> name += "t";
            case 10 -> name += "j";
            case 11 -> name += "q";
            case 12 -> name += "k";
        }
        switch (suit) {
            case 0 -> name += "c";
            case 1 -> name += "d";
            case 2 -> name += "h";
            case 3 -> name += "s";
        }
        return name;

    }

    private BufferedImage rescaleImage(BufferedImage image) {
        int newWidth = imageWidth;
        int newHeight = (int) (image.getHeight() * ((double) newWidth / image.getWidth()));
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        image.getGraphics().drawImage(scaledImage, 0, 0, null);
        return (BufferedImage) image;
    }

}