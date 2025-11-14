import java.util.Arrays;

class CStairs {
    public static void main(String[] args){
        System.out.println(climbStairs(4, new int[]{1,2,3,4}));
    }

    public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        return dp(0, dp, costs);
    }

    private static int dp(int i, int[] dp, int[] costs){
        if (dp[i] > -1) return dp[i];
        int min = 1000000000;
        if (i<costs.length) min = Math.min(min, 1 + costs[i] + dp(i+1, dp, costs));
        if (i+1<costs.length) min = Math.min(min, 4 + costs[i+1] + dp(i+2, dp, costs));
        if (i+2<costs.length) min = Math.min(min, 9 + costs[i+2] + dp(i+3, dp, costs));
        dp[i] = min;
        return min;
    }
}
