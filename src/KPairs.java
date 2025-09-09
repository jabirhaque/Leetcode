import java.util.ArrayList;
import java.util.List;

class KPairs {
    public static void main(String[] args){
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int i = 0;
        int j = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (result.size()<k){
            result.add(List.of(nums1[i], nums2[j]));
            if (i+1<nums1.length && j+1<nums2.length && nums1[i+1]-nums1[i]<nums2[j+1]-nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return result;
    }
}