import java.util.*;

class ThreeSum {
    public static void main(String[] args){
        threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Map<List<Integer>, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++){
            int target = 0-nums[i];
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if (nums[j]+nums[k] == target){
                    if (!map.containsKey(List.of(nums[i], nums[j], nums[k]))){
                        map.put(List.of(nums[i], nums[j], nums[k]), 1);
                        list.add(List.of(nums[i], nums[j], nums[k]));
                    }
                    j++;
                }else if (nums[j]+nums[k] < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return list;
    }
}