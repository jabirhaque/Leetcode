import java.util.HashMap;
import java.util.Map;

class DeleteMap {
    public static void main(String[] args){
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
    }

    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) map.put(n, map.getOrDefault(n,0)+1);
        return max(map, new HashMap<>());
    }

    private static int max(Map<Integer, Integer> map, Map<Map<Integer, Integer>, Integer> dp){
        int max = 0;
        if (dp.containsKey(map)) return dp.get(map);
        Map<Integer, Integer> copy = new HashMap<>(map);
        for (int remove: copy.keySet()){
            int lessCount = map.getOrDefault(remove-1,0);
            int count = map.getOrDefault(remove,0);
            int moreCount = map.getOrDefault(remove+1,0);
            map.remove(remove-1);
            map.remove(remove);
            map.remove(remove+1);
            max = Math.max(max, remove*count+max(map, dp));
            if (lessCount>0) map.put(remove-1, lessCount);
            if (count>0) map.put(remove, count);
            if (moreCount>0) map.put(remove+1, moreCount);
        }
        dp.put(copy, max);
        return max;
    }
}