class SplitArray {
    public static void main(String[] args){
        System.out.println(splitArray(new int[]{3,1,2}));
    }

    public static long splitArray(int[] nums) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        boolean[] leftIncreasing = new boolean[nums.length];
        leftIncreasing[0] = true;
        for (int i=1; i<nums.length; i++){
            if (nums[i]>nums[i-1]) leftIncreasing[i] = true;
            else break;
        }
        boolean[] rightDecreasing = new boolean[nums.length];
        rightDecreasing[nums.length-1] = true;
        for (int i=nums.length-2; i>=0; i--){
            if (nums[i]>nums[i+1]) rightDecreasing[i] = true;
            else break;
        }
        long min = Long.MAX_VALUE;
        for (int i=0; i<nums.length-1; i++){
            if (leftIncreasing[i] && rightDecreasing[i+1]){
                min = Math.min(min, Math.abs(prefix[i] - (prefix[nums.length-1] - prefix[i])));
            }
        }
        if (min == Long.MAX_VALUE) return -1;
        return min;
    }
}