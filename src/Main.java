public class Main {
    public static boolean win;

    public static void main(String[] args) {
        Player[] players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        Deck deck = new Deck();
        playNotchWar(players[0], players[1], deck);
    }

    public static boolean checkWin(Player player0, Player player1) {
        if (!player0.hasCards()) {
            win = true;
            return true;
        }
        if (!player1.hasCards()) {
            win = true;
            return true;
        }
        return false;
    }

    public static void playNotchWar(Player player0, Player player1, Deck deck) {
        //Dealing the 26 cards
        deal(player0, player1, deck);
        while (!win) {
            playRound(player0, player1);
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
            //war
            //TODO:Write this section
            System.err.println("WAR");
            throw new RuntimeException("WAR");
        } else if (Math.abs(cardA.compareTo(cardB)) == 1) {
            //Notched
            System.out.println(cardA + " versus " + cardB + " (Notched!)");
            //noinspection ComparatorResultComparison
            if (cardA.compareTo(cardB) == -1) {
                //player0 wins
                player0.put(cardB);
                player0.put(cardA);
                System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
            } else {
                //player1 wins
                player1.put(cardB);
                player1.put(cardA);
                System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
            }
        } else if (cardA.compareTo(cardB) > 0) {
            //player0 wins
            System.out.println(cardA + " versus " + cardB);
            player0.put(cardB);
            player0.put(cardA);
            System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
        } else if (cardA.compareTo(cardB) < 0) {
            //player1 wins
            System.out.println(cardA + " versus " + cardB);
            player1.put(cardB);
            player1.put(cardA);
            System.out.println("Player 0 has: " + player0.size() + " Player 1 has: " + player1.size());
        }
    }
}