import java.util.HashMap;
import java.util.Map;

class MinSwaps {
    public static void main(String[] args){
        System.out.println(minSwap(new int[]{0,3,5,8,9}, new int[]{2,1,4,6,9}));
    }

    public static int minSwap(int[] nums1, int[] nums2) {
        return recursion(nums1, nums2, 0, new HashMap<>());
    }

    private static int recursion(int[] nums1, int[] nums2, int i, Map<String, Integer> map){
        if (i == nums1.length) return 0;
        String key = "";
        if (i!=0) key += nums1[i-1];
        key += (","+i);
        if (map.containsKey(key)) return map.get(key);
        int temp = nums1[i];
        nums1[i] = nums2[i];
        nums2[i] = temp;
        int min = Integer.MAX_VALUE;
        if (i == 0 || nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
            min = 1+recursion(nums1, nums2, i+1, map);
        }
        temp = nums1[i];
        nums1[i] = nums2[i];
        nums2[i] = temp;
        if (i == 0 || nums1[i]>nums1[i-1] && nums2[i]>nums2[i-1]){
            min = Math.min(min, recursion(nums1, nums2, i+1, map));
        }
        map.put(key, Math.min(min, map.getOrDefault(key, Integer.MAX_VALUE)));
        return min;
    }
}
