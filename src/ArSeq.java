import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ArSeq {
    public static void main(String[] args){
        System.out.println(longestArithSeqLength(new int[]{0,8,45,88,48,68,28,55,17,24}));
    }

    public static int longestArithSeqLength(int[] nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
            max = Math.max(max, count.get(nums[i]));
        }
        int[][] dp = new int[nums.length][1001];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        for (int i=0; i<nums.length; i++){
            for (int diff = -500; diff<=500; diff++){
                max = Math.max(max, 1+max(nums, i, diff, map, dp));
            }
        }
        return max;
    }

    private static int max(int[] nums, int i, int diff, Map<Integer, Integer> map, int[][] dp){
        if (i == nums.length) return 0;
        if (dp[i][diff+500] > -1) return dp[i][diff+500];
        if (!map.containsKey(nums[i]+diff) || i == map.get(nums[i]+diff)) return 0;
        dp[i][diff+500] = 1+max(nums, map.get(nums[i]+diff), diff, map, dp);
        return dp[i][diff+500];
    }
}