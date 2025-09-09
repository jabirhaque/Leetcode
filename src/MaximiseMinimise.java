import java.util.Arrays;

class MaximiseMinimise {
    public static void main(String[] args){
        System.out.println(minimizeArrayValue(new int[] {13,13,20,0,8,9,9}));
    }

    public static int minimizeArrayValue(int[] nums) {
        while (true){ //3, 7, 1, 6
            boolean swap = false;
            int i = findIndexOfLargest(nums); // 1
            while (i>0 && nums[i]-nums[i-1]>0){ //3, 7, 1, 6 -> 5, 5, 1, 6
                swap = true;
                nums[i] = nums[i]-1;
                nums[i-1] = nums[i-1]+1;
            }
            if (!swap){
                Arrays.sort(nums);
                return nums[nums.length-1];
            }
        }
    }

    private static int findIndexOfLargest(int[] nums){
        int[] sortedNums = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            sortedNums[i] = nums[i];
        }
        Arrays.sort(sortedNums);
        int max = sortedNums[nums.length-1];
        for (int i=0; i<nums.length; i++){
            if (nums[i] == max){
                return i;
            }
        }
        return -1;
    }
}