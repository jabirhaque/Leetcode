class SubStringBuild {
    public static void main(String[] args){
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i=0; i<dp.length; i++) for (int j=0; j<dp[0].length; j++){
            if (j == dp[0].length-1) dp[i][j] = 1;
            else if (i == dp.length-1) dp[i][j] = 0;
            else dp[i][j] = -1;
        }
        return dp(s, t, 0, 0, dp);
    }

    private static int dp(String s, String t, int i, int j, int[][] dp){
        if (dp[i][j] > -1) return dp[i][j];
        int count = dp(s, t, i+1, j, dp);
        if (s.charAt(i) == t.charAt(j)) count += dp(s, t, i+1, j+1, dp);
        dp[i][j] = count;
        return count;
    }
}