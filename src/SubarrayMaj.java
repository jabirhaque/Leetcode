import java.util.ArrayList;
import java.util.List;

class SubarrayMaj {
    public static void main(String[] args){
        System.out.println(countMajoritySubarrays(new int[]{1,2,2,3}, 2));
    }

    public static int countMajoritySubarrays(int[] nums, int target) {
        int[] prefix = new int[nums.length+1];
        for (int i=1; i<prefix.length; i++) prefix[i] = prefix[i-1]+(nums[i-1] == target?1:0);
        int count = 0;
        for (int i=0; i<prefix.length; i++){
            for (int j=0; j<i; j++){
                if (2*(prefix[i]-prefix[j]) > i-j) count++;
            }
        }
        return count;
    }
}