package me.janeve.java5.enums;

import java.util.*;

/**
 * See https://docs.oracle.com/javase/1.5.0/docs/guide/language/enums.html for details.
 *
 * It reads two numbers from the command line, representing the number of hands to deal
 * and the number of cards per hand. Then it creates a new deck of cards, shuffles it,
 * and deals and prints the requested hands.
 *
 * To run the method, run as:
 *
 * java me.janeve.java5.enums.Deal 4 5
 *
 */
public class Deal {

    public static void main(String[] args) {
        int numHands = Integer.parseInt(args[0]);
        int cardsPerHand = Integer.parseInt(args[1]);

        List<Card> deck  = Card.newDeck();
        Collections.shuffle(deck);

        for (int i=0; i < numHands; i++)
            System.out.println(deal(deck, cardsPerHand));
    }

    public static ArrayList<Card> deal(List<Card> deck, int n) {
        int deckSize = deck.size();
        List<Card> handView = deck.subList(deckSize-n, deckSize);
        ArrayList<Card> hand = new ArrayList<Card>(handView);
        handView.clear();
        return hand;
    }

}
