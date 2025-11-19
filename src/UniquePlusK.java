import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UniquePlusK {
    public static void main(String[] args){
        System.out.println(maxDistinctElements(new int[]{9,10,10,9,9,9,10,10}, 1));
    }

    public static int maxDistinctElements(int[] nums, int k) {
        int[] dupe = new int[nums.length];
        for (int i=0; i<nums.length; i++) dupe[i] = nums[i];
        return Math.max(smallestFirst(nums, k), biggestFirst(dupe, k));
    }

    public static int smallestFirst(int[] nums, int k) {
        Arrays.sort(nums);
        nums[0] = nums[0]-k;
        int i=1;
        while (i<nums.length){
            int min = Math.max(nums[i-1]+1, nums[i]-k);
            if (min>nums[i]+k) break;
            nums[i] = min;
            i++;
        }
        int j=nums.length-1;
        while (j>=i){
            if (j == nums.length-1) nums[j]+=k;
            else{
                int max = Math.min(nums[j+1]-1, nums[j]+k);
                if (max<nums[j]-k) break;
                nums[j] = max;
            }
            j--;
        }
        return unique(nums);
    }

    public static int biggestFirst(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
        nums[0] = nums[0]+k;
        int i=1;
        while (i<nums.length){
            int max = Math.min(nums[i-1]-1, nums[i]+k);
            if (max<nums[i]-k) break;
            nums[i] = max;
            i++;
        }
        int j=nums.length-1;
        while (j>=i){
            if (j == nums.length-1) nums[j]-=k;
            else{
                int min = Math.max(nums[j+1]+1, nums[j]-k);
                if (min>nums[j]+k) break;
                nums[j] = min;
            }
            j--;
        }
        return unique(nums);
    }

    private static int unique(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);
        return set.size();
    }
}