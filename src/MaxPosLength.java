class MaxPosLength {
    public static void main(String[] args){
        System.out.println(getMaxLen(new int[]{70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86}));
    }

    public static int getMaxLen(int[] nums) {
        Integer firstPositive = -1;
        Integer firstNegative = null;
        int max = 0;
        long product = 1;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0){
                product = 1;
                firstPositive = i;
                firstNegative = null;
            }else{
                product*=nums[i];
                if (product > 0) max = Math.max(max, i-firstPositive);
                else{
                    if (firstNegative == null) firstNegative = i;
                    else max = Math.max(max, i-firstNegative);
                }
            }
        }
        return max;
    }
}