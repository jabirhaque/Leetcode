class Q1 {
    public static void main(String[] args){
        System.out.println(strangePrinter("aba"));
    }

    public static int strangePrinter(String s) {
        int[][][] dp = new int[s.length()][s.length()][27];
        for (int i = 0; i<dp.length; i++) for (int j=0; j<dp[0].length; j++) for (int k=0; k<dp[0][0].length; k++) dp[i][j][k] = -1;
        return dp(s, 0, s.length()-1, (char)('a'+26), dp);
    }

    private static int dp(String s, int i, int j, char c, int[][][] dp){
        if (i == j){
            if (s.charAt(i) == c) return 0;
            return 1;
        }
        if (dp[i][j][c-'a'] > -1) return dp[i][j][c-'a'];
        boolean equal = true;
        for (int k=i+1; k<=j; k++){
            if (s.charAt(k) != s.charAt(k-1)){
                equal = false;
                break;
            }
        }
        if (equal){
            if (s.charAt(i) == c) return 0;
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int x=0; x<26; x++){
            for (int k=i; k<j; k++){
                int left = dp(s, i, k, (char)(x+'a'), dp);
                int right = dp(s, k+1, j, (char)(x+'a'), dp);
                int move = x == c-'a'?0:1;
                min = Math.min(min, move+left+right);
            }
        }
        dp[i][j][c-'a'] = min;
        return min;
    }
}