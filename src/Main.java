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
}
