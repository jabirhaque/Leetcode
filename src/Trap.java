import java.awt.desktop.SystemSleepEvent;
import java.util.*;

public class Trap {

    public static int mod = 1000000007;

    public static void main(String[] args){
        System.out.println(countTrapezoids(new int[][]{{1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}}));
    }

    public static int countTrapezoids(int[][] points) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] point: points){
            map.put(point[1], map.getOrDefault(point[1], 0L)+1);
        }
        for (int n: map.keySet()){
            long i = (map.get(n)*(map.get(n)-1))/2;
            map.put(n, i);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<Long> values = new ArrayList<>();
        for (int key: keys){
            values.add(map.get(key));
        }
        long[] prefix = new long[values.size()];
        for (int i=prefix.length-2; i>=0; i--){
            prefix[i] = (prefix[i+1]+values.get(i+1))%mod;
        }
        int sum = 0;
        for (int i=0; i<prefix.length; i++){
            sum = (int)((sum+prefix[i]*values.get(i))%mod);
        }
        return sum;
    }
}
