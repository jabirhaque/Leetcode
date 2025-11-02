class MinDel {
    public static void main(String[] args){
        System.out.println(minimumDeletions(new int[]{2,10,7,5,4,1,8,6}));
    }

    public static int minimumDeletions(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i]<nums[minIndex]) minIndex = i;
            if (nums[i]>nums[maxIndex]) maxIndex = i;
        }
        if (minIndex == maxIndex) return 1;
        return Math.min(Math.min(minIndex, maxIndex)+1+nums.length-Math.max(maxIndex, minIndex), Math.min(Math.max(minIndex, maxIndex)+1, nums.length-Math.min(minIndex, maxIndex)));
    }
}