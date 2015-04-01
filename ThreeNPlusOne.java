import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by sgscuser9 on 3/26/2015.
 */
public class ThreeNPlusOne {
    static int[] cycle = new int[1000005];
    public static void main(String[] args) throws IOException {
        InputStream f = ASequence.class.getResourceAsStream("input3.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        StringBuffer sb = new StringBuffer("");
        String line = null;
        int testcase_count = 1;
        Arrays.fill(cycle, 0);
        while ((line = br.readLine()) != null) {
            String[] s = line.split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            System.out.println(start+" "+end+" "+calc(start, end));

        }
    }

    private static int calc(int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end + 1; i++) {
            int t = calc(i);
            if(max < t){
                max = t;
            }
        }
        return max;
    }

    private static int calc(int n){
//        System.out.println(n);
        if(n ==1) return 1;
        if (cycle[n] != 0) return cycle[n];
        if ((n & 1)== 1){
            cycle[n] = calc(3*n +1)+1;
        }else{
            int m = n >> 1;
            cycle[n] = calc(m)+1;
        }
//        System.out.println(n+" "+cycle[n]);
        return cycle[n];
    }


}
