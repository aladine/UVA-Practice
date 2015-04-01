import java.util.PriorityQueue;

/**
 * Created by aladine on 22/3/15.
 */
public class Utility {

    class pair<X, Y> { // utilizing Java "Generics"
        X _first;
        Y _second;

        public pair(X f, Y s) {
            _first = f;
            _second = s;
        }

        X first() {
            return _first;
        }

        Y second() {
            return _second;
        }

        void setFirst(X f) {
            _first = f;
        }

        void setSecond(Y s) {
            _second = s;
        }
    }
}

    
//
//
///////////
//    int V = 100;
//    int[][] AdjMat = new int[V][];
//    for (int i = 0; i < V; i++) {
//        AdjMat[i] = new int[V];
//        for (int j = 0; j < V; j++)
//            AdjMat[i][j] = sc.nextInt();
//    }
//
//
////////////
//
//
//
//
//    Vector< Vector< pair < Integer, Integer > > > AdjList = new Vector< Vector< pair < Integer, Integer > > >(V);
//    for (int i = 0; i < V; i++) { // for each vertex
//        Vector< pair < Integer, Integer > > Neighbor = new Vector < pair < Integer, Integer > >();
//        AdjList.add(Neighbor); // add this empty neighbor list to Adjacency List
//    }
//
//    for (int i = 0; i < V; i++) {
//        total_neighbors = sc.nextInt();
//        for (int j = 0; j < total_neighbors; j++) {
//            id = sc.nextInt();
//            weight = sc.nextInt();
//            AdjList.get(i).add( new pair < Integer, Integer > (id - 1, weight)); // some index adjustment
//        }
//    }
//
//
//
//// Bucketsort
//    E = sc.nextInt();
//    PriorityQueue< pair < Integer, pair < Integer, Integer > > > EdgeList = new PriorityQueue < pair < Integer, pair < Integer, Integer > > >(1,
//            new Comparator< pair < Integer, pair < Integer, Integer > > >() { // overriding the compare method
//                public int compare(pair < Integer, pair < Integer, Integer > > i, pair < Integer, pair < Integer, Integer > > j) {
//                    return i.first() - j.first(); // currently min heap based on cost
//                }
//            }
//    );
//
//    //////////
//
//
//}
