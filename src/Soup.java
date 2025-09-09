class Soup {
    public static void main(String[] args){
        System.out.println(soupServings(1));
    }

    public static double soupServings(int n) {
        int side = 4+(int)Math.ceil((double)n/(double)25);
        double[][] dp = new double[side][side];
        for (int i=0; i<side; i++){
            for (int j=0; j<side; j++){
                if (i<4 && j<4){
                    dp[i][j] = 0.5;
                }else if (i<4){
                    dp[i][j] = 1;
                }else if (j<4){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = -1;
                }
            }
        }
        return recursion(dp, side-1, side-1);
    }

    private static double recursion(double[][] dp, int i, int j){
        if (dp[i][j] !=-1){
            return dp[i][j];
        }
        double sum = 0.25*(recursion(dp, i-4, j) + recursion(dp, i-3, j-1) + recursion(dp, i-2, j-2)+ recursion(dp, i-1, j-3));
        dp[i][j] = sum;
        return sum;
    }
}