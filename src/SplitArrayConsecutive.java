class SplitArrayConsecutive {
    public static void main(String[] args){
        System.out.println(isPossible(new int[]{1,2,3,3,4,5}));
    }

    public static boolean isPossible(int[] nums) {
        return recursion(nums, 0, -1, 0);
    }

    private static boolean recursion(int[] nums, int i, int target, int current){
        int sum = 0;
        for (int n:nums) sum+=n;
        if (sum == 0) return current>2;
        for (int j=i; j<nums.length; j++){
            if (nums[j] != 0 && (target == -1 || nums[j] == target)){
                int temp = nums[j];
                nums[j] = 0;
                if (recursion(nums, j+1, temp+1, current+1)) return true;
                else return current > 2 && recursion(nums, j + 1, temp + 1, 1);
            }
        }
        return false;
    }
}