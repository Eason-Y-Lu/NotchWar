//Player.java
//By Yicheng (Eason) Lu for AP-CSA

import java.util.NoSuchElementException;

public class Player extends Queue<Card> {
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
