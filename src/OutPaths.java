class OutPaths {
    public static void main(String[] args){
        System.out.println(findPaths(2,2,2,0,0));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[maxMove+1][m+2][n+2];
        for (int i=0; i<=maxMove; i++){
            for (int j=0; j<m+2; j++){
                for (int k=0; k<n+2; k++){
                    if (j==0 || j==m+1 || k==0 || k==n+1) dp[i][j][k] = 1;
                    else if (i == 0) dp[i][j][k] = 0;
                    else dp[i][j][k] = -1;
                }
            }
        }
        return dp(dp, startRow+1, startColumn+1, maxMove);
    }

    private static int dp(int[][][] dp, int i, int j, int moves){
        if (dp[moves][i][j] > -1) return dp[moves][i][j];
        int res = dp(dp, i-1, j, moves-1) + dp(dp, i+1, j, moves-1) + dp(dp, i, j-1, moves-1) + dp(dp, i, j+1, moves-1);
        dp[moves][i][j] = res;
        return res;
    }
}