import java.util.Vector;

/**
 * Created by aladine on 22/3/15.
 */
public class AdjacencyList {
    Vector<Vector< IntegerPair >> AdjList;

    static class IntegerPair{
        int x;
        int y;

        public IntegerPair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
