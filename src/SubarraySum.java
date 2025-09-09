import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static void main(String[] args){
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n: nums){
            sum += n;
            count += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
