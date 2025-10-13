import java.util.*;

class FourSum {
    public static void main(String[] args){
        System.out.println(fourSum(new int[]{-1000000000,-1000000000,1000000000,-1000000000,-1000000000}, 294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) map.put(nums[i], i);
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                for (int k=j+1; k<nums.length; k++){
                    int temp = target-nums[i]-nums[j]-nums[k];
                    long temp1 = (long)target-(long)nums[i]-(long)nums[j]-(long)nums[k];
                    if (temp1>=Integer.MIN_VALUE && temp1<=Integer.MAX_VALUE && map.containsKey(temp) && map.get(temp) > k){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(temp);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(set);
        return list;
    }
}