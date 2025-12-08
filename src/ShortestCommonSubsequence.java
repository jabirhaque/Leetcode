import java.util.Arrays;

class ShortestCommonSubsequence {
    public static void main(String[] args){
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }

    public static String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        dp[str1.length()][str2.length()] = 0;
        dp(str1, str2, 0, 0, dp);
        return build(str1, str2, 0, 0, dp);
    }

    private static String build(String str1, String str2, int i, int j, int[][] dp){
        if (dp[i][j] == 0) return "";
        if (i < str1.length() && dp[i][j] == 1 + dp[i+1][j]) {
            return str1.charAt(i) + build(str1, str2, i+1, j, dp);
        }
        if (j < str2.length() && dp[i][j] == 1 + dp[i][j+1]) {
            return str2.charAt(j) + build(str1, str2, i, j+1, dp);
        }
        return str1.charAt(i) + build(str1, str2, i+1, j+1, dp);
    }

    private static int dp(String str1, String str2, int i, int j, int[][] dp){
        if (dp[i][j] > -1) return dp[i][j];
        int shortest = 2000;
        if (i<str1.length()) shortest = 1+dp(str1, str2, i+1, j, dp);
        if (j<str2.length()) shortest = Math.min(shortest, 1+dp(str1, str2, i, j+1, dp));
        if (i<str1.length() && j<str2.length() && str1.charAt(i) == str2.charAt(j)) shortest = Math.min(shortest, 1+dp(str1, str2, i+1, j+1, dp));
        dp[i][j] = shortest;
        return dp[i][j];
    }
}