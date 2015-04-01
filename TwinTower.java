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

    private static boolean calc(int n, int k, int[] tower1, int[] tower2) {
        return false;
    }
}
