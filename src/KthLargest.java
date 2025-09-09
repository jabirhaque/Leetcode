import java.util.Arrays;

class KthLargest {

    int k;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        Arrays.sort(nums);
        this.k = k;
        this.nums = new int[k];
        for (int i=0; i<k; i++){
            this.nums[i] = nums[nums.length-k+i];
        }
    }

    public int add(int val) {
        if (val>nums[0]){
            nums[0] = val;
            int i=0;
            while (i<nums.length-1 && nums[i]>nums[i+1]){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        return nums[0];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */