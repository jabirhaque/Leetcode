import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Apples {
    public static void main(String[] args){
        System.out.println(eatenApples(new int[]{1,2,3,5,2}, new int[]{3,2,1,4,2}));
    }

    public static int eatenApples(int[] apples, int[] days) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<apples.length; i++) if (apples[i] > 0) list.add(i);
        Collections.sort(list, (a, b) -> (b+days[b])==(a+days[a]) ? days[a]-days[b] : (b+days[b])-(a+days[a]));
        int count = 0;
        int max = Integer.MAX_VALUE;
        for (int i: list){
            int ceil = Math.min(max, i+days[i]-1);
            int floor = Math.max(i, ceil-apples[i]+1);
            int incr = Math.max(0, ceil-floor+1);
            count += incr;
            if (incr>0) max = floor - 1;
        }
        return count;
    }
}