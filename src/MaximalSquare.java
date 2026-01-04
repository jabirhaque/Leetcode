import java.util.Arrays;

class MaximalSquare {
    public static void main(String[] args){
        System.out.println(maximalSquare(new char[][]{{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}}));
    }

    public static int maximalSquare(char[][] matrix) {
        int[][] horizontal = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            horizontal[i][matrix[0].length-1] = matrix[i][matrix[0].length-1] == '1'?1:0;
            for (int j=matrix[0].length-2; j>=0; j--){
                if (matrix[i][j] == '1') horizontal[i][j] = horizontal[i][j+1]+1;
                else horizontal[i][j] = 0;
            }
        }
        int[][] vertical = new int[matrix.length][matrix[0].length];
        for (int j=0; j<matrix[0].length; j++){
            vertical[matrix.length-1][j] = matrix[matrix.length-1][j] == '1'?1:0;
            for (int i=matrix.length-2; i>=0; i--){
                if (matrix[i][j] == '1') vertical[i][j] = vertical[i+1][j]+1;
                else vertical[i][j] = 0;
            }
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] arr: dp) Arrays.fill(arr, -1);

        int max = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                max = Math.max(max, dp(horizontal, vertical, i, j, dp));
            }
        }
        return max*max;
    }

    private static int dp(int[][] horizontal, int[][] vertical, int i, int j, int[][] dp){
        if (i == horizontal.length || j == horizontal[0].length) return 0;
        if (dp[i][j] > -1) return dp[i][j];
        int min = Math.min(horizontal[i][j], vertical[i][j]);
        int nextMax = dp(horizontal, vertical, i+1, j+1, dp);
        int res = 0;
        if (min != 0) res = Math.max(Math.min(min, nextMax+1), 1);
        dp[i][j] = res;
        return res;
    }
}