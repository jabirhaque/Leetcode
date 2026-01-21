import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Floor {
    public static void main(String[] args){
        avoidFlood(new int[]{1,0,2,3,0,1,2});
    }

    public static int[] avoidFlood(int[] rains) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b-a);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> zeros = new HashMap<>();
        for (int i=0; i<rains.length; i++){
            if (rains[i] == 0) queue.add(i);
            else{
                if (map.containsKey(rains[i])){
                    if (queue.isEmpty()) return new int[0];
                    int index = queue.poll();
                    if (index < map.get(rains[i])) return new int[0];
                    zeros.put(index, rains[i]);
                }
                map.put(rains[i], i);
            }
        }
        int[] res = new int[rains.length];
        for (int i=0; i<rains.length; i++){
            if (rains[i] > 0) res[i] = -1;
            else res[i] = zeros.getOrDefault(i, 1);
        }
        return res;
    }
}