import java.io.*;
import java.util.*;

/**
 * Created by sgscuser9 on 3/24/2015.
 */
public class Agurs {
    public static PriorityQueue<pair<Long, Integer>> pq ;
    public static Set<pair<Integer, Integer>> s = new HashSet<pair<Integer, Integer>>();

    public static void main(String[] args) throws IOException {
//        InputStream f = Agurs.class.getResourceAsStream("input1.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(f));//System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while (!(line = br.readLine()).equals("#")){
            String[] l = line.split(" ");
            register(Integer.parseInt(l[1]),Integer.parseInt(l[2]));
        }

        int K = Integer.parseInt(br.readLine());
        int size = K * s.size();
        pq = new PriorityQueue<pair<Long, Integer>>(size, new Comparator<pair<Long, Integer>>() {
            @Override
            public int compare(pair<Long, Integer> o1, pair<Long, Integer> o2) {
                return (int)(o1.x- o2.x);
            }
        });
//        System.out.println(K);
        List<Long> list = new ArrayList<Long>();
        for(pair<Integer, Integer> p: s){
            long idx = p.y;
            long limit = (K+1)* (p.y);
//            System.out.println(idx+"-"+K);
            while(idx < limit){
//                System.out.println(idx+"--"+p.x);
                pq.add(new pair<Long, Integer>(idx, p.x));
                idx += p.y;
            }
        }
        for(int ix = K; ix>0; ix--){
            System.out.println(pq.poll().y);
        }
        // print K times. each time may have differenet queue numbers

//        for(pair<Integer, Integer> p: pq){
//            System.out.println(p.toString());
//        }
    }

    private static void register(int x, int y) {
        s.add(new pair<Integer, Integer>(x, y));
    }
}

class pair<X, Y>{
    X x;
    Y y;

    public pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return x.toString()+" "+y.toString();
    }
}


