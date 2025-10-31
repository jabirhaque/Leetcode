import java.util.Arrays;

class ArraySum {
    public static void main(String[] args){
        System.out.println(minOperations(new int[]{1,2,3,4,5,6}, new int[]{1,1,2,2,2,2}));
    }

    public static int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int n: nums1) sum1 += n;
        for (int n: nums2) sum2 += n;
        if (sum1<sum2) return min(nums1, nums2, sum2-sum1);
        return min(nums2, nums1, sum1-sum2);
    }

    private static int[] reverse(int[] nums){
        for (int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }
        return nums;
    }

    private static int min(int[] smaller, int[] bigger, int rem){
        Arrays.sort(smaller);
        Arrays.sort(bigger);
        reverse(bigger);
        int i=0;
        int j=0;
        int count = 0;
        while (rem>0 && (i<smaller.length || j<bigger.length)){
            if (i<smaller.length && (j==bigger.length || 6-smaller[i] > bigger[j]-1)){
                rem -= Math.min(rem, 6-smaller[i]);
                i++;
            }else {
                rem -= Math.min(rem, bigger[j]-1);
                j++;
            }
            count++;
        }
        if (rem == 0) return count;
        return -1;
    }
}