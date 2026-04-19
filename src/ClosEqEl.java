import java.util.*;

class ClosEqEl {
    public static void main(String[] args){
        ClosEqEl closEqEl = new ClosEqEl();
        closEqEl.solveQueries(new int[]{6,12,17,9,16,7,6}, new int[]{5,6,0,4});
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int[] left = left(nums);
        int[] right = right(nums);
        for (int i=0; i<nums.length; i++){
            if (left[i] == -1) left[i] = right[i];
            else if (right[i] != -1) left[i] = Math.min(left[i], right[i]);
        }
        List<Integer> result = new ArrayList<>();
        for (int n: queries){
            result.add(left[n]);
        }
        return result;
    }

    private int[] left(int[] nums){
        int[] left = new int[nums.length];
        Arrays.fill(left, -1);
        Map<Integer, Integer> latestMap = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (latestMap.containsKey(nums[i])) left[i] = i-latestMap.get(nums[i]);
            latestMap.put(nums[i], i);
            if (firstMap.containsKey(nums[i])){
                left[i] = Math.min(left[i], nums.length-i+firstMap.get(nums[i]));
            }else{
                firstMap.put(nums[i], i);
            }
        }
        return left;
    }

    private int[] right(int[] nums){
        int[] right = new int[nums.length];
        Arrays.fill(right, -1);
        Map<Integer, Integer> latestMap = new HashMap<>();
        Map<Integer, Integer> firstMap = new HashMap<>();
        for (int i=nums.length-1; i>=0; i--){
            if (latestMap.containsKey(nums[i])) right[i] = latestMap.get(nums[i])-i;
            latestMap.put(nums[i], i);
            if (firstMap.containsKey(nums[i])){
                right[i] = Math.min(right[i], nums.length-firstMap.get(nums[i])+i);
            }else{
                firstMap.put(nums[i], i);
            }
        }
        return right;
    }
}