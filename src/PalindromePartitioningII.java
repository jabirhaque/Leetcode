import java.util.Arrays;

class PalindromePartitioningII {
    public static void main(String[] args){
        System.out.println(minCut("bb"));
    }

    public static int minCut(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++){
            int j=0;
            while (i-j>=0 && i+j<s.length() && s.charAt(i-j) == s.charAt(i+j)){
                isPalindrome[i-j][i+j] = true;
                j++;
            }
        }
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                int l=i;
                int r=i+1;
                while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                    isPalindrome[l][r] = true;
                    l--;
                    r++;
                }
            }
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        dp[s.length()-1] = 0;
        return minCuts(s, isPalindrome, dp, 0);
    }

    private static int minCuts(String s, boolean[][] isPalindrome, int[] dp, int i){
        if (dp[i]>-1) return dp[i];
        int min = Integer.MAX_VALUE;
        for (int j=i; j<s.length(); j++){
            if (isPalindrome[i][j]){
                if (j == s.length()) min = 0;
                else min = Math.min(min, 1+minCuts(s, isPalindrome, dp, j+1));
            }
        }
        dp[i] = min;
        return min;
    }
}