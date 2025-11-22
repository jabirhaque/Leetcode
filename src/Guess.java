class Guess {
    public static void main(String[] args){
        System.out.println(getMoneyAmount(10));
    }

    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i >= j) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }
        return min(1, n, dp);
    }

    private static int min(int i, int j, int[][] dp){
        if (i-1<0 || j-1<0) return 0;
        if (dp[i-1][j-1] > -1) return dp[i-1][j-1];
        int min = Integer.MAX_VALUE;
        for (int k=i; k<j; k++){
            int res = k+Math.max(min(i, k-1, dp), min(k+1, j, dp));
            min = Math.min(min, res);
        }
        dp[i-1][j-1] = min;
        return min;
    }
}