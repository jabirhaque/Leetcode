class LongestNewString {
    public static void main(String[] args){
        longestString(2, 5, 1);
    }

    public static int longestString(int x, int y, int z) {
        int[][][][] dp = new int[x+1][y+1][z+1][4];
        for (int i=0; i<dp.length; i++) for (int j=0; j<dp[0].length; j++) for (int k=0; k<dp[0][0].length; k++) for (int l=0; l<dp[0][0][0].length; l++) dp[i][j][k][l] = -1;
        return dp(x, y, z, 0, dp);
    }

    private static int dp(int x, int y, int z, int last, int[][][][] dp){
        if (dp[x][y][z][last] > -1) return dp[x][y][z][last];
        int max = 0;
        if (x > 0 && last != 1) max = Math.max(max, 2+dp(x-1, y, z, 1, dp));
        if (y > 0 && last != 2 && last != 3) max = Math.max(max, 2+dp(x, y-1, z, 2, dp));
        if (z > 0 && last != 1) max = Math.max(max, 2+dp(x, y, z-1, 3, dp));
        dp[x][y][z][last] = max;
        return max;
    }
}