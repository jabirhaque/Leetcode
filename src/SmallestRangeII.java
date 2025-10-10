import java.util.Arrays;

class SmallestRangeII {
    public static void main(String[] args){
        System.out.println(smallestRangeII(new int[]{0,10}, 2));
    }

    public static int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) nums[i] -= k;
        int min = nums[nums.length-1]-nums[0];
        for (int i=0; i<nums.length; i++){
            nums[i] += 2*k;
            min = Math.min(min, partition(nums, i));
        }
        return min;
    }

    private static int partition(int[] nums, int i){
        int min = Math.min(nums[0], i+1<nums.length?nums[i+1]:nums[0]);
        int max = Math.max(nums[i], nums[nums.length-1]);
        return max-min;
    }
}