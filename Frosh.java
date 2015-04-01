import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by aladine on 23/3/15.
 */
public class Frosh {
    public static int[] arr = new int[1000000];
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb=new StringBuffer("");
        int n = Integer.parseInt(br.readLine());
//        if (n <= 0 || n > 2000000) break;
//            String s[] = br.readLine().split(" ");

        for (int j = 0; j < n; j++) {
            arr[j] = Integer.parseInt(br.readLine());
        }
        mergesort(0,n-1);
        System.out.println(count);
    }

    private static void mergesort(int st, int ed) {
//        System.out.printf("%d -> %d \n", st, ed);
        if(st >= ed) return;
        if(ed-st ==1){
            if(arr[st]>arr[ed]){
                int tmp = arr[st];
                arr[st] = arr[ed];
                arr[ed]= tmp;
                count++;
            }
            return;
        }
        int mid = (int)(ed - (ed-st)/2);
        mergesort( st, mid);
        mergesort( mid+1,ed);
        merge( st, mid, ed);
    }

    private static void merge( int st, int mid, int ed) {
        int id1  = st, id2 = mid+1, id = st;
        int[] tmp =  new int[ed-st+1];
        while(id1 <=  mid && id2<= ed) {
            if (arr[id1] <= arr[id2]) {
                tmp[id] = arr[id1++];
            } else {
                tmp[id] = arr[id2++];
                count += (mid-id1+1);
            }
            id++;
        }
        for (int i = 0; i < ed-st+1; i++) {
            arr[i] = tmp[i-st];
        }
    }
}
