import java.util.ArrayList;

public class Main {
    public static boolean win;

    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        Deck deck = new Deck();
    }

    public static boolean checkWin(Player player1, Player player2) {
        if (!player1.hasCards()) {
            win = true;
            return true;
        }
        if (!player2.hasCards()) {
            win = true;
            return true;
        }
        return false;
    }

    public static void playNotchWar() {
        while (!win) {
            //TODO:Write this
        }

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


}