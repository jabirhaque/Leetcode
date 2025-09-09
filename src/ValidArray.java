import java.util.Arrays;

public class ValidArray {
    public static void main(String[] args){
        System.out.println(minRemoval(new int[]{466,306,76,17,60,246,341,284}, 2));
    }

    public static int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++){
            int max = i;
            int l=i;
            int r=nums.length-1;
            while (l<r){
                int m = (l+r)/2;
                if (nums[m]>(long)k*(long)nums[i]){
                    r=m;
                }else{
                    max = Math.max(max, m);
                    l = m+1;
                }
            }
            if (nums[l]<=(long)k*(long)nums[i]){
                max = Math.max(max, l);
            }
            min = Math.min(min, i+nums.length-1-max);
        }
        return min;
    }
}
