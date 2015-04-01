import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sgscuser9 on 3/27/2015.
 */
public class WhatGoesUp {
    final static int MAX_N = 100000;
    public static void main(String[] args) throws IOException {
//        main_problem();
//        System.exit(0);
        final int MAX = 100000;
        InputStream f = ASequence.class.getResourceAsStream("input4.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(f));
        StringBuffer sb = new StringBuffer("");
        String line = null;
        int[] A = new int[MAX];
        int count  = 0;
        while(null != (line = br.readLine())){
            A[count++] = (Integer.parseInt(line));
        }
        calcLIS(count + 1, A);
    }

//    private static void main_problem() {
//
//        int n = 11;
//        int[] A = new int[] {-7, 10, 9, 2, 3, 8, 8, 1, 2, 3, 4};
//        int[] L_id = new int[MAX_N], P = new int[MAX_N];
//        Vector<Integer> L = new Vector<Integer>();
//
//        int lis = 0, lis_end = 0;
//        for (int i = 0; i < n; ++i) {
//            int pos = Collections.binarySearch(L, A[i]);
//            if (pos < 0) pos = -(pos + 1); // some adjustments are needed
//            if (pos >= L.size()) L.add(A[i]);
//            else                 L.set(pos, A[i]);
//            L_id[pos] = i;
//            P[i] = pos > 0 ? L_id[pos - 1] : -1;
//            if (pos + 1 > lis) {
//                lis = pos + 1;
//                lis_end = i;
//            }
//
//            System.out.printf("Considering element A[%d] = %d\n", i, A[i]);
//            System.out.printf("LIS ending at A[%d] is of length %d: ", i, pos + 1);
//            reconstruct_print(i, A, P);
//            System.out.println("L is now: " + L);
//            System.out.printf("\n");
//        }
//
//        System.out.printf("Final LIS is of length %d: ", lis);
//        reconstruct_print(lis_end, A, P);
//    }

    static void reconstruct_print(int end, int[] a, int[] p) {
        int x = end;
        Stack<Integer> s = new Stack();
        for (; p[x] >= 0; x = p[x]) s.push(a[x]);
        System.out.printf("[%d", a[x]);
        for (; !s.isEmpty(); s.pop()) System.out.printf(", %d", s.peek());
        System.out.printf("]\n");
    }

    private static void calcLIS(int size, int[] A) {
        // using LIS nlogk
        Vector<Integer> L = new Vector<Integer>();


        int[] L_id = new int[MAX_N], P = new int[MAX_N];
        int lis = 0, lis_end = 0;

        for (int i = 0; i < size; i++) {
            int pos = Collections.binarySearch(L, A[i]);
            if(pos < 0) pos = - (pos +1);
            if(L.size()==0 || pos > L.size()) L.add(pos);
            else L.set(pos, A[pos]);

            L_id[pos] = i;
            P[i] = pos > 0 ? L_id[pos - 1] : -1;
            if (pos + 1 > lis) {
                lis = pos + 1;
                lis_end = i;
            }
            System.out.printf("Considering element A[%d] = %d\n", i, A[i]);
            System.out.printf("LIS ending at A[%d] is of length %d: ", i, pos + 1);
            reconstruct_print(i, A, P);
            System.out.println("L is now: " + L);

        }
        System.out.printf("Final LIS is of length %d: ", lis);
        reconstruct_print(lis_end, A, P);
    }
}
