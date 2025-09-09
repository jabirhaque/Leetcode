import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Offers {
    public static void main(String[] args){
        System.out.println(shoppingOffers(List.of(3, 4), List.of(List.of(1,2,3), List.of(1,2,5)), List.of(2,2)));
    }

    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return recursion(price, special, needs, new HashMap<>());
    }

    private static int recursion(List<Integer> prices, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> map){
        if (map.containsKey(needs)){
            return map.get(needs);
        }
        int sum = 0;
        for (int n: needs){
            sum+=n;
            if (n<0){
                return -1;
            }
        }
        if (sum == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> s: special){
            List<Integer> newNeeds = new ArrayList<>();
            for (int i=0; i<needs.size(); i++){
                newNeeds.add(needs.get(i)-s.get(i));
            }
            int res = recursion(prices, special, newNeeds, map);
            if (res!=-1){
                min = Math.min(min, s.get(s.size()-1)+res);
            }
        }
        int ordinary = 0;
        for (int i=0; i<needs.size(); i++){
            ordinary += prices.get(i)*needs.get(i);
        }
        min = Math.min(min, ordinary);
        map.put(needs, min);
        return min;
    }
}