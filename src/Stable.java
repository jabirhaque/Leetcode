class Stable {
    public static int mod = 1000000007;

    public static void main(String[] args){
        System.out.println(countStableSubsequences(new int[]{1,3,5}));
    }

    public static int countStableSubsequences(int[] nums) {
        int[][][][] dp = new int[nums.length+1][3][3][2];
        for (int i=0; i<dp.length; i++) for (int j=0; j<3; j++) for (int k=0; k<3; k++) for (int l=0; l<2; l++) dp[i][j][k][l] = -1;
        return recursion(nums, 0, 2, 2, 0, dp);
    }

    private static int recursion(int[] nums, int i, int even, int odd, int used, int[][][][] dp){
        if (dp[i][even][odd][used]>-1) return dp[i][even][odd][used];
        if (i == nums.length) return used;
        int count = 0;
        if (nums[i]%2==0 && even>0) count = (count+recursion(nums, i+1, even-1, 2, 1, dp))%mod;
        if (nums[i]%2==1 && odd>0) count = (count+recursion(nums, i+1, 2, odd-1, 1, dp))%mod;
        count = (count+recursion(nums, i+1, even, odd, used, dp))%mod;
        dp[i][even][odd][used] = count;
        return count;
    }
}