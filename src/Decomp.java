import java.util.HashMap;
import java.util.Map;

public class Decomp {
    public static void main(String[] args){
        System.out.println(result(new int[]{1,2,1,3,4,2}));
    }

    static int result(int[] nums){
        int i=0;
        int count = 0;
        while (i<nums.length){
            int j=i;
            Map<Integer, Integer> map = new HashMap<>();
            while (j<nums.length && !map.containsKey(nums[j])){
                map.put(nums[j], 1);
                j++;
            }
            count++;
            i=j;
        }
        return count;
    }
}
