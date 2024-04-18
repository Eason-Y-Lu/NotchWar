//Player.java

import java.util.NoSuchElementException;

public class Player extends Stack<Card> {
    public boolean hasCards() {
        //Because calling peek() could resolve in NoSuchElement Exception, it is handled here rather than in Main
        try {
            //Return value is ignored.
            Card notUsed = this.peek();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}