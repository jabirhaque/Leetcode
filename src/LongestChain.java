import java.util.HashMap;
import java.util.Map;

class LongestChain {
    public static void main(String[] args){
        System.out.println(maximumLength(new int[]{10,5}, 6));
    }

    public static int maximumLength(int[] nums, int k) {
        for (int i=0; i<nums.length; i++) nums[i]%=k;
        int max = 0;
        int[][] dp = new int[k][nums.length];
        for (int target=0; target<k; target++){
            dp[target][nums.length-1] = 1;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[nums.length-1], nums.length-1);
            for (int i=nums.length-2; i>=0; i--){
                int next = target-nums[i];
                if (next<0) next+=k;
                if (map.containsKey(next)) dp[target][i] = 1+dp[target][map.get(next)];
                else dp[target][i] = 1;
                map.put(nums[i], i);
                max = Math.max(max, dp[target][i]);
            }
        }
        return max;
    }
}