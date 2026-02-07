import java.util.Arrays;

class BalSt {
    public static void main(String[] args){
        System.out.println(minimumDeletions("bbaaaaabb"));
    }

    public static int minimumDeletions(String s) {
        int[] count = new int[s.length()];
        for (int i=s.length()-2; i>=0; i--){
            count[i] = count[i+1];
            if (s.charAt(i+1) == 'a') count[i]++;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return min(s, 0, count, dp);
    }

    private static int min(String s, int i, int[] count, int[] dp){
        if (i == s.length()) return 0;
        if (dp[i] > -1) return dp[i];
        int min;
        if (s.charAt(i) == 'a') min = min(s, i+1, count, dp);
        else{
            min = 1+min(s, i+1, count, dp);
            min = Math.min(min, count[i]);
        }
        dp[i] = min;
        return min;
    }
}