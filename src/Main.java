import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        Deck deck = new Deck();
        deal(players[0], players[1], deck);
    }

    public static void deal(Player playerA, Player playerB, Deck deck) {
        for (int i = 0; i < 26; i++) {
            playerA.put(deck.getCard());
            playerB.put(deck.getCard());
        }
    }

    public static void playRound(Player playerA, Player playerB) {
        Card pACard = playerA.get();
        Card pBcard = playerB.get();
        if (pACard.equals(pBcard)) {
            //WAR
            ArrayList<Card> onTable = new ArrayList<Card>();
            onTable.add(pACard);
            onTable.add(pBcard);
            war(playerA, playerB, onTable);
        } else if (pACard.compareTo(pBcard) < 0) {
            //PlayerB Wins
            playerB.put(pACard);
            playerB.put(pBcard);
        } else {
            //PlayerA Wins
            playerA.put(pBcard);
            playerA.put(pACard);
        }
    }

    public static void war(Player playerA, Player playerB, ArrayList<Card> onTable) {

    }
}