import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by aladine on 22/3/15.
 */
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        String[] line;
        n = Integer.parseInt(sc.nextLine());
        while(n>0)
        {
            line = sc.nextLine().split(" ");
            sort(line);
            n = Integer.parseInt(sc.nextLine());
        }
    }

    private static void sort(String[] names){
        int[] ages = new int[names.length];
        int[] buckets = new int[100];
        for (int i = 0; i < names.length; i++) {
            ages[i] = Integer.parseInt(names[i]);
        }
        Arrays.fill(buckets, 0);
        for(String str: names){
            int x = str.toLowerCase().charAt(0) - '0';
            buckets[x]++;
        }
        for (int i = 1; i < 26; i++) {
            buckets[i] += buckets[i-1];
        }
        String[] new_array = new String[names.length];
        for(String str: names){
            int x = str.toLowerCase().charAt(0) - '0';
            new_array[buckets[x] -1] = str;
            buckets[x] --;
        }

        for (int i = 0; i < new_array.length; i++) {
            System.out.print(new_array[i] + " ");
        }
        System.out.print("\n");
    }
}
