import java.util.Arrays;

class PathMinEff {
    public static void main(String[] args){
        System.out.println(minimumEffortPath(new int[][]{{7,2,6,5}, {3,1,10,8}}));
    }


    public static int minimumEffortPath(int[][] heights) {
        int[][] dp = new int[heights.length][heights[0].length];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        return dp(dp, heights, 0, 0, 0);
    }

    static int dp(int[][] dp, int[][] heights, int i, int j, int current){
        if (dp[i][j] > -1 && dp[i][j] <= current) return -1;
        dp[i][j] = current;
        if (i == heights.length-1 && j == heights[0].length-1) return current;
        int min = Integer.MAX_VALUE;
        if (i-1>=0){
            int res = dp(dp, heights, i-1, j, Math.max(current, Math.abs(heights[i-1][j]-heights[i][j])));
            if (res > -1) min = Math.min(min, res);
        }
        if (i+1<heights.length){
            int res = dp(dp, heights, i+1, j, Math.max(current, Math.abs(heights[i+1][j]-heights[i][j])));
            if (res > -1) min = Math.min(min, res);
        }
        if (j-1>=0){
            int res = dp(dp, heights, i, j-1, Math.max(current, Math.abs(heights[i][j-1]-heights[i][j])));
            if (res > -1) min = Math.min(min, res);
        }
        if (j+1<heights[0].length){
            int res = dp(dp, heights, i, j+1, Math.max(current, Math.abs(heights[i][j+1]-heights[i][j])));
            if (res > -1) min = Math.min(min, res);
        }
        return min;
    }
}