import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by aladine on 23/3/15.
 */
public class Skyline {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer("");
        String line = null;
        while ((line = br.readLine()) != null){
            String[] l = line.split(" ");

            List<IntegerTriple> buildings = new ArrayList<IntegerTriple>();
            buildings.add(new IntegerTriple(Integer.parseInt(l[0]), Integer.parseInt(l[1]), Integer.parseInt(l[2])));
        }
        br.close();
//        SegmentTree st = new SegmentTree();
        //maintain 2 arrays of min and max.
        // each update: add a L, H , R will update from each point H to a[i], max(H, a[i]), b[j] and min(H, b[j])
    }
}

class SegmentTree {         // the segment tree is stored like a heap array
    private int[] st, A;
    private int n;
    private int left (int p) { return p << 1; } // same as binary heap operations
    private int right(int p) { return (p << 1) + 1; }

    private void build(int p, int L, int R) {
        if (L == R)                            // as L == R, either one is fine
            st[p] = L;                                         // store the index
        else {                                // recursively compute the values
            build(left(p) , L              , (L + R) / 2);
            build(right(p), (L + R) / 2 + 1, R          );
            int p1 = st[left(p)], p2 = st[right(p)];
            st[p] = (A[p1] <= A[p2]) ? p1 : p2;
        } }

    private int rmq(int p, int L, int R, int i, int j) {          // O(log n)
        if (i >  R || j <  L) return -1; // current segment outside query range
        if (L >= i && R <= j) return st[p];               // inside query range

        // compute the min position in the left and right part of the interval
        int p1 = rmq(left(p) , L              , (L+R) / 2, i, j);
        int p2 = rmq(right(p), (L+R) / 2 + 1, R          , i, j);

        if (p1 == -1) return p2;   // if we try to access segment outside query
        if (p2 == -1) return p1;                               // same as above
        return (A[p1] <= A[p2]) ? p1 : p2; }          // as as in build routine

    private int update_point(int p, int L, int R, int idx, int new_value) {
        // this update code is still preliminary, i == j
        // must be able to update range in the future!
        int i = idx, j = idx;

        // if the current interval does not intersect
        // the update interval, return this st node value!
        if (i > R || j < L)
            return st[p];

        // if the current interval is included in the update range,
        // update that st[node]
        if (L == i && R == j) {
            A[i] = new_value; // update the underlying array
            return st[p] = L; // this index
        }

        // compute the minimum position in the
        // left and right part of the interval
        int p1, p2;
        p1 = update_point(left(p) , L              , (L + R) / 2, idx, new_value);
        p2 = update_point(right(p), (L + R) / 2 + 1, R          , idx, new_value);

        // return the position where the overall minimum is
        return st[p] = (A[p1] <= A[p2]) ? p1 : p2;
    }

    public SegmentTree(int[] _A) {
        A = _A; n = A.length;                   // copy content for local usage
        st = new int[4 * n];
        for (int i = 0; i < 4 * n; i++) st[i] = 0; // create vector with length `len' and fill it with zeroes
        build(1, 0, n - 1);                                  // recursive build
    }

    public int rmq(int i, int j) { return rmq(1, 0, n - 1, i, j); } // overloading

    public int update_point(int idx, int new_value) {
        return update_point(1, 0, n - 1, idx, new_value); }
}


class FenwickTree {
    private Vector<Integer> ft;

    private int LSOne(int S) { return (S & (-S)); }

    public FenwickTree() {}

    // initialization: n + 1 zeroes, ignore index 0
    public FenwickTree(int n) {
        ft = new Vector<Integer>();
        for (int i = 0; i <= n; i++) ft.add(0);
    }

    public int rsq(int b) {                              // returns RSQ(1, b)
        int sum = 0; for (; b > 0; b -= LSOne(b)) sum += ft.get(b);
        return sum; }

    public int rsq(int a, int b) {                       // returns RSQ(a, b)
        return rsq(b) - (a == 1 ? 0 : rsq(a - 1)); }

    // adjusts value of the k-th element by v (v can be +ve/inc or -ve/dec)
    void adjust(int k, int v) {                    // note: n = ft.size() - 1
        for (; k < (int)ft.size(); k += LSOne(k)) ft.set(k, ft.get(k) + v); }
};

class IntegerTriple implements Comparable {
    Integer _first, _second, _third;

    public IntegerTriple(Integer f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    public int compareTo(Object o) {
        if (!this.first().equals(((IntegerTriple)o).first()))
            return this.first() - ((IntegerTriple)o).first();
        else if (!this.second().equals(((IntegerTriple)o).second()))
            return this.second() - ((IntegerTriple)o).second();
        else
            return this.third() - ((IntegerTriple)o).third();
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }

    public String toString() { return first() + " " + second() + " " + third(); }
}
