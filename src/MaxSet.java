import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxSet {
    public static void main(String[] args){
        System.out.println(maximumSetSize(new int[]{5,1,9,5,6,4,9,6,7,6}, new int[]{7,6,9,2,10,8,3,10,8,2}));
    }

    public static int maximumSetSize(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums1){
            map1.put(n, map1.getOrDefault(n, 0)+1);
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (int n: nums2){
            map2.put(n, map2.getOrDefault(n, 0)+1);
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        for (int n: map.keySet()) queue.add(n);
        int r1 = nums1.length/2;
        int r2 = nums2.length/2;
        int count = 0;
        while (r1>0 || r2>0){
            int remove = queue.poll();
            if (r1>0 && map1.getOrDefault(remove, 0) > 0){
                map1.put(remove, map1.get(remove)-1);
                map.put(remove, map.get(remove)-1);
                if (map.get(remove) > 0) queue.add(remove);
                r1--;
            }else if (r2>0 && map2.getOrDefault(remove, 0) > 0){
                map2.put(remove, map2.get(remove)-1);
                map.put(remove, map.get(remove)-1);
                if (map.get(remove) > 0) queue.add(remove);
                r2--;
            }else count++;
        }
        return queue.size()+count;
    }
}
