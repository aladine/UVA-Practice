import java.util.*;

/**
 * Created by aladine on 22/3/15.
 */
class DNASorting {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        String[] line;
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            sc.nextLine();
            line = sc.nextLine().split(" ");
            int len = Integer.parseInt(line[0]);
            int num = Integer.parseInt(line[1]);
            solve(len, num);
        }
    }

    public static Map<String,Integer> map = new HashMap<String, Integer>();

    private static void solve(int len, int num) {
        List<Pair> list = new ArrayList<Pair>() ;
        for (int i = 0; i < num; i++) {
            String l = sc.nextLine();
            list.add(new Pair(l, calc(len, l)));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.y > o2.y) return 1;
                if(o1.y < o2.y) return -1;
                return 0;
            }
        });
        for(Pair entry: list){
            System.out.println(entry.x);
        }
    }

    private static int calc(int len, String l) {
        int inversion = 0;

        int[] count = new int[4];

        for (int i = 0; i < len; i++) {
            char c = l.charAt(i);
            switch (c){
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
                default:
            }
        }

        int new_pos = 0;

        for (int i = 0; i < len; i++) {
            char c = l.charAt(i);
            switch (c){
                case 'A':
                    count[0]--;
                    break;
                case 'C':
                    count[1]--;
                    new_pos = (count[0]);
                    inversion += new_pos;
                    break;
                case 'G':
                    count[2]--;
                    new_pos = (count[0]) + (count[1]);
                    inversion += new_pos;
                    break;
                case 'T':
                    count[3]--;
                    new_pos = (count[0]) + (count[1]) + (count[2]);
                    inversion += new_pos;

                    break;
                default:
            }
        }
        return inversion;
    }

    static class Pair{
        String x;
        int y;

        public Pair(String x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
