import java.util.HashMap;
import java.util.Map;

class HouseRobber {
    public static void main(String[] args){
        System.out.println(rob(new int[]{1,2}));
    }

    public static int rob(int[] nums) {
        return recursion(nums, 0, new HashMap<>());
    }

    private static int recursion(int[] nums, int i, Map<Integer, Integer> map){
        if (map.containsKey(i)){
            return map.get(i);
        }
        int max = 0;
        if (i>=nums.length){
            return 0;
        }
        for (int j=i; j<nums.length; j++){
            max = Math.max(max, nums[j]+recursion(nums, j+2, map));
        }
        map.put(i, max);
        return max;
    }
}