class Arith {
    public static void main(String[] args){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3) return 0;
        int[] dp = new int[nums.length];
        dp[nums.length-2] = 2;
        int count = 0;
        for (int i=nums.length-3; i>=0; i--){
            if (nums[i+1]-nums[i] == nums[i+2]-nums[i+1]) dp[i] = dp[i+1]+1;
            else dp[i] = 1;
            count += Math.max(0, dp[i]-2);
        }
        return count;
    }
}