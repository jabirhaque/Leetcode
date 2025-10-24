import java.util.HashMap;
import java.util.Map;

class MaxPosLengthII {
    public static void main(String[] args){
        System.out.println(getMaxLen(new int[]{0,1,-2,-3,-4}));
    }

    public static int getMaxLen(int[] nums) {
        Map<Integer, Integer> positive = new HashMap<>();
        Map<Integer, Integer> negative = new HashMap<>();
        positive.put(nums.length, 0);
        negative.put(nums.length, 0);
        dp(nums, 0, positive, negative);
        int max = 0;
        for (int n: positive.keySet()) max = Math.max(max, positive.get(n));
        return max;
    }

    private static void dp(int[] nums, int i, Map<Integer, Integer> positive, Map<Integer, Integer> negative){
        if (positive.containsKey(i)) return;
        dp(nums, i+1, positive, negative);
        if (nums[i] == 0){
            positive.put(i, 0);
            negative.put(i, 0);
            return;
        }
        if (nums[i] > 0){
            positive.put(i, 1+positive.get(i+1));
            if (negative.get(i+1) == 0) negative.put(i, 0);
            else negative.put(i, 1+negative.get(i+1));
        }
        if (nums[i] < 0){
            negative.put(i, 1+positive.get(i+1));
            if (negative.get(i+1) == 0) positive.put(i, 0);
            else positive.put(i, 1+negative.get(i+1));
        }
    }
}