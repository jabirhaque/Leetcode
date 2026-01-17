import java.util.*;

class DeleteAndEarn {
    public static void main(String[] args){
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }

    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n, 0)+1);
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int[] dp = new int[list.size()];
        Arrays.fill(dp, -1);
        return dp(list, map, 0, dp);
    }

    private static int dp(List<Integer> list, Map<Integer, Integer> map, int i, int[] dp){
        if (i == list.size()) return 0;
        if (dp[i] > -1) return dp[i];
        int max = dp(list, map, i+1, dp);
        int j = (i+1 < list.size() && list.get(i+1) == 1+list.get(i)) ? i+2 : i+1;
        max = Math.max(max, list.get(i)*map.get(list.get(i)) + dp(list, map, j, dp));
        dp[i] = max;
        return max;
    }
}