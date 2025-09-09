class DistinctSubsequence {
    public static void main(String[] args){
        System.out.println(numDistinct("babgbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i=0; i<=s.length(); i++){
            for (int j=0; j<=t.length(); j++){
                if (j == t.length()){
                    dp[i][j] = 1;
                }else if (i == s.length()){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = -1;
                }
            }
        }
        return recursion(dp, s, t, 0, 0);
    }

    private static int recursion(int[][] dp, String s, String t, int i, int j){
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int total = recursion(dp, s, t, i+1, j);
        if (s.charAt(i) == t.charAt(j)){
            total += recursion(dp, s, t, i+1, j+1);
        }
        dp[i][j] = total;
        return total;
    }
}