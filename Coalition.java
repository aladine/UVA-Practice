import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sgscuser9 on 3/30/2015.
 */
public class Coalition {

    public static float uni = 0f;
    public static void main(String[] args) throws IOException {
        final int MAX = 100000;
        InputStream f = Coalition.class.getResourceAsStream("input5.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        StringBuffer sb = new StringBuffer("");
        String line = null;
        int[] A = new int[MAX];
        while (!(line = br.readLine()).startsWith("0 0")) {
            String[] l = line.split(" ");
            int N = Integer.parseInt(l[0]);
            int K = Integer.parseInt(l[1]);
            float[] v = new float[N];
            float val = 0f;
            int count = 0;
            for (int i = 0; i < N; i++) {
                v[i] = Float.parseFloat(br.readLine());
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += v[i];
            }
            val = v[K-1];
            uni = v[K-1];
            v[K-1] = 0;
            System.out.printf("%.2f\n",100*calc(val, N, v,sum));
        }
    }

    private static float calc(float val, int n, float[] v, float sum) {
        if(val >= sum/2) {
            return (uni)/val;
        }

        if(n == 1){
            if(val+v[0] >= sum/2){
                return uni/(v[0]+ val);
            }
            else return 0;
        }else {
            float f1 = calc(val, n -1, v, sum);
            float f2 = calc(val+ v[n-1],n-1, v,sum);
            return Math.max(f1, f2);
        }
    }
}
