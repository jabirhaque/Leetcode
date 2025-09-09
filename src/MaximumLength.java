import java.util.HashSet;
import java.util.Set;

class MaximumLength {
    public static void main(String[] args){
        System.out.println(maximumLength(new int[] {4,3,7,7,2,6,10}, 6));
    }

    public static int maximumLength(int[] nums, int k) {
        int max = 0;
        for (int i=0; i<nums.length; i++){
            Set<Integer> set = new HashSet<>();
            for (int j=i+1; j<nums.length; j++){
                int remainder = (nums[i]+nums[j])%k;
                if (set.contains(remainder)){
                    break;
                }
                set.add(remainder);
                int last = nums[j];
                int count = 2;
                int x=j+1;
                while (x<nums.length){
                    while (x<nums.length && (nums[x]+last)%k!=remainder){
                        x++;
                    }
                    if (x<nums.length){
                        count++;
                        last = nums[x];
                    }
                    x = x+1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}