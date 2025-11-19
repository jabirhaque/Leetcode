class MaxVal {
    public static void main(String[] args){
        System.out.println(maximumTripletValue(new int[]{2,3,1}));
    }

    public static long maximumTripletValue(int[] nums) {
        int[] maxBefore = new int[nums.length];
        maxBefore[0] = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++){
            maxBefore[i] = Math.max(maxBefore[i-1], nums[i-1]);
        }
        int[] biggestPair = new int[nums.length];
        biggestPair[0] = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++){
            biggestPair[i] = Math.max(biggestPair[i-1], maxBefore[i]-nums[i]);
        }
        int max = 0;
        for (int i=2; i<nums.length; i++){
            max = Math.max(max, nums[i]*biggestPair[i-1]);
        }
        return max;
    }
}