import java.util.HashMap;
import java.util.Map;

class Discard {
    public static void main(String[] args){
        System.out.println(minArrivalsToDiscard(new int[]{7,3,9,9,7,3,5,9,7,2,6,10,9,7,9,1,3,6,2,4,6,2,6,8,4,8,2,7,5,6}, 10, 1));
    }
    public static int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arrivals[0], 1);
        int discard = 0;
        for (int i=0; i<arrivals.length; i++){
            if (i+1-w>=0) map.put(arrivals[i+1-w], map.get(arrivals[i+1-w])-1);
            if (i+1<arrivals.length){
                if (map.getOrDefault(arrivals[i+1], 0) == m) discard++;
                else map.put(arrivals[i+1], map.getOrDefault(arrivals[i+1], 0)+1);
            }
        }
        return discard;
    }
}
