import java.util.HashMap;
import java.util.Map;

class Groups {
    public static void main(String[] args){
        System.out.println(partitionArray(new int[]{74, 103, 74}, 50000));
    }

    public static boolean partitionArray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:nums){
            map.put(n, map.getOrDefault(n, 0));
        }
        int min = 1;
        for (int n:map.keySet()){
            if (map.get(n)>min){
                min = map.get(n);
            }
        }
        return nums.length>=min*k && nums.length%k==0;
    }
}