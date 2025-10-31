class Abs {
    public static void main(String[] args){
        System.out.println(minElements(new int[]{1,-1,1}, 3, -4));
    }

    public static int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int n: nums) sum += n;
        long required = goal - sum;
        long res = (Math.abs(required)/limit) + (Math.abs(required)%limit==0?0:1);
        if (res>=Integer.MIN_VALUE && res<=Integer.MAX_VALUE) return (int)res;
        return -1;
    }
}