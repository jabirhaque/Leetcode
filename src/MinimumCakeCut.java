class MinimumCakeCut {
    public static void main(String[] args){
        System.out.println(minimumCost(2, 2, new int[]{7}, new int[]{4}));
    }

    public static int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int[][][][] dp = new int[m+1][n+1][m+1][n+1];
        for (int sr=0; sr<=m; sr++){
            for (int sc=0; sc<=n; sc++){
                for (int er = sr+1; er<=m; er++){
                    for (int ec=sc+1; ec<=n; ec++){
                        if (er-sr == 1 && ec-sc == 1) dp[sr][sc][er][ec] = 0;
                        else dp[sr][sc][er][ec] = -1;
                    }
                }
            }
        }
        return dp(dp, 0, 0, m, n, horizontalCut, verticalCut);
    }

    private static int dp(int[][][][] dp, int sr, int sc, int er, int ec, int[] horizontalCut, int[] verticalCut){
        if (dp[sr][sc][er][ec] > -1) return dp[sr][sc][er][ec];
        int min = Integer.MAX_VALUE;
        for (int i=sr+1; i<er; i++){
            min = Math.min(min, horizontalCut[i-1] + dp(dp, sr, sc, i, ec, horizontalCut, verticalCut) + dp(dp, i, sc, er, ec, horizontalCut, verticalCut));
        }
        for (int j=sc+1; j<ec; j++){
            min = Math.min(min, verticalCut[j-1] + dp(dp, sr, sc, er, j, horizontalCut, verticalCut) + dp(dp, sr, j, er, ec, horizontalCut, verticalCut));
        }
        dp[sr][sc][er][ec] = min;
        return min;
    }
}