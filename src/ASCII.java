import java.util.Arrays;

class ASCII {
    public static void main(String[] args){
        System.out.println(minimumDeleteSum("delete", "leet"));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        return min(s1, s2, 0, 0, dp);
    }

    private static int min(String s1, String s2, int i, int j, int[][] dp){
        if (dp[i][j] > -1) return dp[i][j];
        if (i == s1.length() && j == s2.length()) return 0;
        if (i == s1.length()){
            dp[i][j] = s2.charAt(j)+min(s1, s2, i, j+1, dp);
            return dp[i][j];
        }
        if (j == s1.length()){
            dp[i][j] = s1.charAt(i)+min(s1, s2, i+1, j, dp);
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;

        int keep = min(s1, s2, i+1, j+1, dp);
        int first = min(s1, s2, i+1, j, dp);
        int second = min(s1, s2, i, j+1, dp);

        if (s1.charAt(i) == s2.charAt(j) && keep > -1) min = Math.min(min, keep);
        if (first > -1) min = Math.min(min, s1.charAt(i)+first);
        if (second > -1) min = Math.min(min, s2.charAt(j)+second);

        dp[i][j] = min;
        return min;
    }
}