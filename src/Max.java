class Max {
    public static void main(String[] args){
        int result = maxSubArray(new int[]{9,0,-2,-2,-3,-4,0,1,-4,5,-8,7,-3,7,-6,-4,-7,-8});
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int l=0;
        int r=0;
        int sum = nums[0];
        int max = nums[0];
        while (r<nums.length){
            max = Math.max(max, sum);
            if (sum < 0){
                r+=1;
                l=r;
                if (l<nums.length){
                    sum = nums[l];
                }
            }else{
                r++;
                if (r<nums.length){
                    sum+=nums[r];
                }
            }
        }
        return max;
    }
}