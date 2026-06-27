import java.util.HashMap;
import java.util.Map;

public class MaxNumEl {

    public static void main(String[] args){
        MaxNumEl maxNumEl = new MaxNumEl();
        maxNumEl.maximumLength(new int[]{5,4,1,2,2});
    }

    public int maximumLength(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Map<Integer, Integer> map = new HashMap<>();

        int m = 0;
        for (int n : nums) {
            m = Math.max(m, maxLength(n, count, map));
        }

        return m;
    }

    public int maxLength(int n, Map<Integer, Integer> count, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (count.getOrDefault(n, 0) < 2) {
            map.put(n, count.getOrDefault(n, 0));
            return count.getOrDefault(n, 0);
        }

        int res = maxLength(n * n, count, map); // watch out for 1

        if (res == 0) {
            map.put(n, 1);
            return 1;
        }

        map.put(n, res + 2);
        return res + 2;
    }
}
