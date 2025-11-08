import java.util.ArrayList;
import java.util.List;

class LongestSub {
    public static void main(String[] args){
        System.out.println(longestSubarray(new int[]{3,-4,-2}));
    }
    public static int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i=1; i<nums.length; i++){
            if (nums[i]<nums[i-1]) list.add(i);
        }
        list.add(nums.length);
        int max = 0;
        for (int i=1; i<list.size(); i++){
            if (list.get(i) != nums.length || list.get(i-1) != -1) max = Math.max(max, list.get(i)-list.get(i-1));
            if (i+1 < list.size() && list.get(i)+1 < nums.length && list.get(i)-1 >= 0 && nums[list.get(i)+1] >= nums[list.get(i)-1]){
                max = Math.max(max, list.get(i)-list.get(i-1)+list.get(i+1)-list.get(i)-1);
            }
        }
        if (max == 0) max = nums.length;
        return max;
    }
}