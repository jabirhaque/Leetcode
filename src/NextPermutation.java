import java.util.Arrays;

class NextPermutation {
    public static void main(String[] args){
        int[] array = new int[] {5,4,7,5,3,2};
        nextPermutation(array);
        System.out.println(Arrays.toString(array));
    }

    public static void nextPermutation(int[] nums) {
        for (int i=nums.length-1; i>=0; i--){
            for (int j=nums.length-1; j>i; j--){
                if (nums[j]>nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    for (int a=0; a<nums.length-i-1; a++){
                        for (int b=i+1; b<nums.length-1; b++){
                            if (nums[b]>nums[b+1]){
                                int temp2 = nums[b];
                                nums[b] = nums[b+1];
                                nums[b+1] = temp2;
                            }
                        }
                    }
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }
}