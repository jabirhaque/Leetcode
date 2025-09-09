import java.util.Arrays;

class Jump {
    public static void main(String[] args){
        System.out.println(Arrays.toString(maxValue(new int[]{20, 21, 25, 15})));
    }
    public static int[] maxValue(int[] nums) {
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            res[i] = recursion(res, nums, i);
        }
        return res;
    }

    private static int recursion(int[] res, int[] nums, int i){
        if (res[i] > 0){
            return res[i];
        }
        res[i] = nums[i];
        for (int j=0; j<nums.length; j++){
            if (j<i && nums[j]>nums[i]){
                res[i] = Math.max(res[i], recursion(res, nums, j));
            }if (j>i && nums[j]<nums[i]){
                res[i] = Math.max(res[i], recursion(res, nums, j));
            }
        }
        return res[i];
    }
}