import java.util.HashMap;
import java.util.Map;

class Waterbottles {
    public static void main(String[] args){
        System.out.println(maxBottlesDrunk(13, 6));
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        return max(numBottles, 0, numExchange, new HashMap<>());
    }

    private static int max(int full, int empty, int exchange, Map<String, Integer> map){
        String key = full + "," + empty + "," + exchange;
        if (map.containsKey(key)) return map.get(key);
        int max = 0;
        if (empty>=exchange){
            max = Math.max(max, max(full+1, empty-exchange, exchange+1, map));
        }
        for (int i=1; i<=full; i++){
            max = Math.max(max, i+max(full-i, empty+i, exchange, map));
        }
        map.put(key, max);
        return max;
    }
}