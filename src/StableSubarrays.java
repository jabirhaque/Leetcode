import java.util.HashMap;
import java.util.Map;

class StableSubarrays {
    public static void main(String[] args){
        System.out.println(countStableSubarrays(new int[]{-4,4,0,0,-8,-4}));
    }
    public static long countStableSubarrays(int[] capacity) {
        long count = 0;
        long[] sums = new long[capacity.length];
        sums[0] = capacity[0];
        for (int i=1; i<sums.length; i++) sums[i] = sums[i-1]+capacity[i];
        Map<String, Long> map = new HashMap<>();
        Map<String, Integer> last = new HashMap<>();
        for (int i=0; i<capacity.length; i++){
            long prefixSum = sums[i]-capacity[i];
            String key = String.valueOf(sums[i])+','+capacity[i];
            long targetSum = prefixSum-capacity[i];
            String targetKey = String.valueOf(targetSum)+','+capacity[i];
            count += map.getOrDefault(targetKey, 0l);
            if (last.getOrDefault(targetKey, -2) == i-1) count--;
            map.put(key, map.getOrDefault(key,0l)+1);
            last.put(key, i);
        }
        return count;
    }
}