import java.util.HashMap;
import java.util.Map;

class Climbing {
    public static void main(String[] args){
        System.out.println(minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> map = new HashMap<>();
        return Math.min(recursion(cost, 0, map), recursion(cost, 1, map));
    }

    private static int recursion(int[] cost, int i, Map<Integer, Integer> map){
        if (map.containsKey(i)){
            return map.get(i);
        }
        if (i>=cost.length){
            return 0;
        }
        int result = cost[i]+Math.min(recursion(cost, i+1, new HashMap<>()), recursion(cost, i+2, new HashMap<>()));
        map.put(i, result);
        return result;
    }
}