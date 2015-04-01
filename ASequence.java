import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sgscuser9 on 3/25/2015.
 */
public class ASequence {
    public static Set<Integer> set = new HashSet<Integer>();
    public static void main(String[] args) throws IOException {
        InputStream f = ASequence.class.getResourceAsStream("input2.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        StringBuffer sb = new StringBuffer("");
        String line = null;
        int testcase_count = 1;
        while ((line = br.readLine()) != null) {
            String[] l = line.split(" ");
            int N = Integer.parseInt(l[0]);
            int []  arr = new int[N];
            System.out.printf("Case %d: ", testcase_count++);
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(l[i+1]);
                System.out.printf("%d ",arr[i]);
            }
            System.out.println("");
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if(set.contains(arr[i])) {
                    flag = true;
                    break;
                }
                generateSet(arr, i);
            }
            if(flag) System.out.println("This is not an A-sequence.");
            else System.out.println("This is an A-sequence.");
        }
        br.close();
    }

    private static void generateSet(int[] arr, int i) {
        if(i==0) set.add(arr[0]);
        for (int j : set){
            set.add(i+j);
        }
    }

//    private static boolean check(int[] arr, int end) {
//        if(arr[end])
//        return check(arr, end-1);
//    }
}
