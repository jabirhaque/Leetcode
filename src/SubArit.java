import java.util.HashMap;
import java.util.Map;

class SubArit {
    public static void main(String[] args){
        System.out.println(longestArithSeqLength(new int[]{3,6,9,12}));
    }

    public static int longestArithSeqLength(int[] nums) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                dp.put(nums[j]-nums[i], new HashMap<>());
            }
        }
        int max = 1;
        for (int diff: dp.keySet()){
            for (int i=0; i<nums.length; i++) max = Math.max(max, recurse(nums, dp, i, diff));
        }
        return max;
    }

    private static int recurse(int[] nums, Map<Integer, Map<Integer, Integer>> dp, int i, int diff){
        if (dp.get(diff).containsKey(i)) return dp.get(diff).get(i);
        int max = 1;
        int target = nums[i]+diff;
        for (int j=i+1; j<nums.length; j++){
            if (nums[j] == target) max = Math.max(max, 1+recurse(nums, dp, j, diff));
        }
        dp.get(diff).put(i, max);
        return max;
    }
}