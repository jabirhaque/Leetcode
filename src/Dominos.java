import java.util.Arrays;

class Dominos {
    public static void main(String[] args){
        System.out.println(numTilings(3));
    }

    public static int numTilings(int n) {
        int[][] dp = new int[n][3];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        return max(n, 0, 0, dp);
    }

    private static int max(int n, int i, int state, int[][] dp){
        if (i == n){
            if (state == 0) return 1;
            else return 0;
        }
        if (i>n) return 0;
        if (dp[i][state]>-1) return dp[i][state];
        int total = 0;
        if (state == 0){
            total += max(n, i+1, 0, dp);
            total += max(n, i+2, 0, dp);
            total += max(n, i+1, 1, dp);
            total += max(n, i+1, 2, dp);
        }
        if (state == 1){
            total += max(n, i+2, 0, dp);
            total += max(n, i+1, 2, dp);
        }
        if (state == 2){
            total += max(n, i+2, 0, dp);
            total += max(n, i+1, 1, dp);
        }
        dp[i][state] = total;
        return total;
    }
}