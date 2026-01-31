import java.util.Arrays;
import java.util.List;

class KnightProbability {
    public static void main(String[] args){
        System.out.println(knightProbability(3,2,0,0));
    }

    public static double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k+1];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dp(row, column, n, k, dp);
    }

    private static double dp(int i, int j, int n, int k, double[][][] dp){
        if (i < 0 || i >= n || j < 0 || j >= n) return 0;
        if (k == 0) return 1;

        if (dp[i][j][k] > -1) return dp[i][j][k];

        double prob = 0;

        prob += dp(i-2, j-1, n, k-1, dp)/8;

        prob += dp(i-2, j+1, n, k-1, dp)/8;

        prob += dp(i-1, j-2, n, k-1, dp)/8;

        prob += dp(i-1, j+2, n, k-1, dp)/8;

        prob += dp(i+2, j-1, n, k-1, dp)/8;

        prob += dp(i+2, j+1, n, k-1, dp)/8;

        prob += dp(i+1, j-2, n, k-1, dp)/8;

        prob += dp(i+1, j+2, n, k-1, dp)/8;

        dp[i][j][k] = prob;

        return prob;
    }
}