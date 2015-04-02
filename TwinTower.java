import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sgscuser9 on 3/30/2015.
 */
public class TwinTower {
    public static void main(String[] args) throws IOException {
        InputStream f = Coalition.class.getResourceAsStream("input6.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        StringBuffer sb = new StringBuffer("");
        String line = null;

        while (!(line = br.readLine()).startsWith("0 0")) {
            String[] l = line.split(" ");
            int N = Integer.parseInt(l[0]);
            int K = Integer.parseInt(l[1]);
            int[] tower1 = new int[N];
            int[] tower2 = new int[K];
            System.out.println(calc(N,K,tower1,tower2));
            System.out.println();

        }
    }

    private static int calc(int n, int k, int[] tower1, int[] tower2) {
        // find the longest string between tower1 and tower2
        if(n==0 || k==0) return 0;
        if(tower1[n-1] == tower2[k -1]){
            return calc(n-1, k-1, tower1, tower2)+1;
        }else {
            return Math.max( calc(n-1, k, tower1, tower2), calc(n, k-1, tower1, tower2));
        }
    }
}
