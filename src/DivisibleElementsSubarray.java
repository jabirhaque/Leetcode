import java.util.HashSet;
import java.util.Set;

class DivisibleElementsSubarray {
    public static void main(String[] args){
        countDistinct(new int[]{2,3,3,2,2}, 2, 2);
    }

    public static int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            String str = ""+nums[i];
            int count = 0;
            if (nums[i]%p==0 && !set.contains(str))count++;
            int j=i;
            while (j<nums.length && count <= k){
                if (!set.contains(str)){
                    set.add(str);
                }
                j++;
                if (j<nums.length){
                    if (nums[j]%p==0) count++;
                    str+=","+nums[j];
                }
            }
        }
        return set.size();
    }
}