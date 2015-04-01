import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aladine on 24/3/15.
 */
public class Palindrome {
    public static void main(String[] args) throws IOException {
        //        InputStream f = Agurs.class.getResourceAsStream("input1.txt");
//        BufferedReader br = new BufferedReader(new InputStreamReader(f));//System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            line = br.readLine();
            String[] l = line.split(" ");
            System.out.println(calc(l[0], Integer.parseInt(l[1])));
        }
    }

    private static int calc(String S, int k) {
        return calc(S, 0, S.length()-1, k);
    }

    private static int calc(String s, int start, int end, int k){
        if(getChange(s, start, end) <= k) return end-start+1;
        return Math.max(calc(s, start + 1, end, k) , calc(s, start, end-1, k));
    }

    public static int getChange(String s,int start,int end){
        int sum = 0;
        if (start> end) return 0;
        int len = end - start+1;
        for (int i = start; i <= start+(len-1)/2; i++) {
            if(s.charAt(i) != s.charAt(end+start - i)){
                sum ++;
            }
        }
        return sum;
    }
}
