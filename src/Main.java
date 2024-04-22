//Main.java

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static boolean WIN;

    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        Deck deck = new Deck();
        playNotchWar(players[0], players[1], deck);
    }

    public static void checkWin(Player player0, Player player1) {
        if (!player0.hasCards()) {
            WIN = true;
            return;
        }
        if (!player1.hasCards()) {
            WIN = true;
        }
    }

    public static void playNotchWar(Player player0, Player player1, Deck deck) {
        //Dealing the 26 cards
        deal(player0, player1, deck);
        while (!WIN) {
            try {
                playRound(player0, player1);
            } catch (RuntimeException runtimeException) {
                System.out.println("There is a draw.");
                return;
            }
            checkWin(player0, player1);
        }
        String winner;
        if (!player0.hasCards()) {
            winner = "Player 1";
        } else {
            winner = "Player 0";
        }

        System.out.println("The winner is... " + winner + " !");
    }

    public static void deal(Player player0, Player player1, Deck deck) {
        for (int i = 0; i < 26; i++) {
            player0.put(deck.getCard());
            player1.put(deck.getCard());
        }
    }

    public static void playRound(Player player0, Player player1) {
        Card cardA = player0.get();
        Card cardB = player1.get();
        if (cardA.equals(cardB)) {
            System.out.println(cardA + " versus " + cardB);
            ArrayList<Card> downCard = new ArrayList<>();
            war(player0, player1, cardA, cardB, downCard);
        } else if (Math.abs(cardA.compareTo(cardB)) == 1) {
            //Notched
            System.out.println(cardA + " versus " + cardB + " (Notched!)");
            //noinspection ComparatorResultComparison
            if (cardA.compareTo(cardB) == -1) {
                //player0 wins
                getCards(player0, cardA, cardB);
                System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
            } else {
                //player1 wins
                getCards(player1, cardA, cardB);
                System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
            }
        } else if (cardA.compareTo(cardB) > 0) {
            //player0 wins
            System.out.println(cardA + " versus " + cardB);
            getCards(player0, cardA, cardB);
            System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
        } else if (cardA.compareTo(cardB) < 0) {
            //player1 wins
            System.out.println(cardA + " versus " + cardB);
            getCards(player1, cardA, cardB);
            System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
        }
    }

    public static void war(Player player0, Player player1, Card cardA, Card cardB, ArrayList<Card> downCard) {
        System.out.println("WAR!");
        for (int i = 0; i < 3; i++) {
            if (player0.hasCards()) {
                downCard.add(cardA);
                cardA = player0.get();
            }
            if (player1.hasCards()) {
                downCard.add(cardB);
                cardB = player1.get();
            }
        }
        if (cardA.equals(cardB)) {
            System.out.println(cardA + " versus " + cardB);
            //Check for Draw, if draw, an error will be thrown.
            if (!player0.hasCards() && !player1.hasCards()) {
                throw new RuntimeException("DRAW");
            }
            war(player0, player1, cardA, cardB, downCard);
        }
        if (cardA.compareTo(cardB) > 0) {
            //player0 wins
            System.out.println(cardA + " versus " + cardB);
            downCard.add(cardA);
            downCard.add(cardB);
            getCards(player0, downCard);
            System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
        } else if (cardA.compareTo(cardB) < 0) {
            //player1 wins
            System.out.println(cardA + " versus " + cardB);
            downCard.add(cardA);
            downCard.add(cardB);
            getCards(player1, downCard);
            System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
        }
    }

    public static void getCards(Player player, Card cardA, Card cardB) {
        SecureRandom random = new SecureRandom();
        if (random.nextBoolean()) {
            player.put(cardA);
            player.put(cardB);
        } else {
            player.put(cardB);
            player.put(cardA);
        }
    }

    public static void getCards(Player player, ArrayList<Card> cards) {
        SecureRandom random = new SecureRandom();
        Collections.shuffle(cards, random);
        for (Card c : cards) {
            player.put(c);
        }
    }
}