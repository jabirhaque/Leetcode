class Dungeon {
    public static void main(String[] args){
        System.out.println(calculateMinimumHP(new int[][] {{0,0}}));
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        for (int i=0; i<dungeon.length; i++) for (int j=0; j<dungeon.length; j++) dp[i][j] = Integer.MIN_VALUE;
        dp[dungeon.length-1][dungeon[0].length-1] = dungeon[dungeon.length-1][dungeon[0].length-1];
        int res = min(dungeon, dp, 0, 0);
        if (res >=0) return 1;
        return -res+1;
    }

    private static int min(int[][] dungeon, int[][] dp, int i, int j){
        if (dp[i][j] > Integer.MIN_VALUE) return dp[i][j];
        int min = Integer.MIN_VALUE;
        if (i+1<dungeon.length) min = Math.min(dungeon[i][j], dungeon[i][j] + min(dungeon, dp, i+1, j));
        if (j+1<dungeon[0].length) min = Math.max(min, Math.min(dungeon[i][j], dungeon[i][j] + min(dungeon, dp, i, j+1)));
        dp[i][j] = min;
        return min;
    }
}