public class Main {
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Deck deck = new Deck();
        deal(player1,player2,deck);
    }
    public static void deal(Player playerA, Player playerB, Deck deck){
        for(int i = 0 ; i<26;i++){
            playerA.put(deck.getCard());
            playerB.put(deck.getCard());
        }
    }
}
