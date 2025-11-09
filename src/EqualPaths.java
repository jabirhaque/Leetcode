class EqualPaths {
    public static void main(String[] args){
        System.out.println(minIncrements(7, new int[]{1,5,2,2,3,3,1}));
    }

    public static int minIncrements(int n, int[] cost) {
        int[] max = max(cost, 0, 0, new int[cost.length]);
        int target = 0;
        for (int m: max) target = Math.max(target, m);
        return count(0, target, 0, max);
    }

    private static int count(int i, int target, int added, int[] max){
        if (i>=max.length) return 0;
        int count = 0;
        count += target - max[i] - added;
        count += count(2*i+1, target, added+target-max[i]-added, max);
        count += count(2*i+2, target, added+target-max[i]-added, max);
        return count;
    }

    private static int[] max(int[] cost, int i, int sum, int[] max){
        if (2*i+1>=cost.length){
            max[i] = sum + cost[i];
            return max;
        }
        max(cost, 2*i+1, sum+cost[i], max);
        max(cost, 2*i+2, sum+cost[i], max);
        max[i] = Math.max(max[2*i+1], max[2*i+2]);
        return max;
    }
}