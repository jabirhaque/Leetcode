import java.util.Arrays;

class JumpGameV {
    public static void main(String[] args){
        JumpGameV jumpGameV = new JumpGameV();
        jumpGameV.maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12}, 2);
    }

    public int maxJumps(int[] arr, int d) {
        int max = 0;
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        for (int i=0; i<arr.length; i++){
            max = Math.max(max, max(arr, i, d, dp));
        }
        return max;
    }

    private int max(int arr[], int i, int d, int[] dp){
        if (dp[i] > -1) return dp[i];
        int max = 1;
        for (int j=i-1; j>=Math.max(0, i-d); j--){
            if (arr[i] > arr[j]) max = Math.max(max, 1+max(arr, j, d, dp));
            else break;
        }
        for (int j=i+1; j<=Math.min(arr.length-1, i+d); j++){
            if (arr[i] > arr[j]) max = Math.max(max, 1+max(arr, j, d, dp));
            else break;
        }
        dp[i] = max;
        return max;
    }
}