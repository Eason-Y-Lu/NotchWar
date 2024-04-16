public class Card implements Comparable<Card> {
    private final String mySymbol;
    private final int myRank;
    private final char mySuit;

    public Card(char rank, char suit) {
        // Note how switch works.  It's really useful.
        // Note also the character arithmetic.
        //
        // Remember, a char has a Unicode
        // value and that needs to be converted.
        switch (rank) {
            case 'A':
                myRank = 14;
                break;
            case 'K':
                myRank = 13;
                break;
            case 'Q':
                myRank = 12;
                break;
            case 'J':
                myRank = 11;
                break;
            case 'T':
                myRank = 10;
                break;
            default:
                myRank = rank - '0';
        }
        mySuit = suit;
        mySymbol = "" + rank + suit;
    }

    public int getRank() {
        return myRank;
    }

    public char getSuit() {
        return mySuit;
    }

    public String getSymbol() {
        return mySymbol;
    }


    public int compareTo(Card card) {
        int rankDiff = this.getRank() - card.getRank();
        //handle special case where if diff is 1 lesser card win
        if (Math.abs(rankDiff) == 1) {
            return (this.getRank() < card.getRank()) ? 1 : -1;
        } else {
            return rankDiff;
        }
    }

    public boolean equals(Card card) {
        //Check if Rank is equal
        return this.getRank() == card.getRank();
    }

    public String toString() {
        return mySymbol;
    }
}
