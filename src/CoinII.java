import java.util.HashSet;
import java.util.Set;

class CoinII {
    public static void main(String[] args){
        System.out.println(change(5, new int[]{1,2,5}));
    }

    public static int change(int amount, int[] coins) {
        Set<Integer> set = new HashSet<>();
        for (int coin: coins){
            set.add(coin);
        }
        int[] dp = new int[amount+1];
        for (int i=0; i<dp.length; i++){
            dp[i] = i==0?1:(set.contains(i)?1:0);
        }
        for (int i=1; i<=amount; i++){
            int sum=0;
            for (int j=0; j<=i/2; j++){
                int k = i-j;
                sum += j==k?(dp[j]*(dp[j]+1))/2:dp[j]*dp[k];
            }
            dp[i] = sum;
        }
        return dp[amount];
    }
}