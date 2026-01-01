import java.util.HashMap;
import java.util.Map;

class CountSubseq {
    public static void main(String[] args){
        System.out.println(numberOfSubsequences(new int[]{3,4,3,4,3,4,3,4}));
    }

    public static long numberOfSubsequences(int[] nums) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i=nums.length-1; i>=0; i--){
            Map<Integer, Integer> m = new HashMap<>();
            if (i+1<nums.length){
                Map<Integer, Integer> m2 = map.get(i+1);
                for (int key: m2.keySet()){
                    m.put(key, m2.get(key));
                }
            }
            for (int j=i+2; j<nums.length; j++){
                m.put(nums[i]*nums[j], m.getOrDefault(nums[i]*nums[j],0)+1);
            }
            map.put(i, m);
        }
        long count = 0;
        for (int i=0; i<nums.length; i++){
            for (int j=i+2; j<nums.length-2; j++){
                count += map.get(j+2).getOrDefault(nums[i]*nums[j],0);
            }
        }
        return count;
    }
}