import java.util.*;

class ValuedBalls {
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{2,5}, 4));
    }

    public static int maxProfit(int[] inventory, int orders) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int n: inventory) map.put(n, map.getOrDefault(n, 0)+1);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int n: map.keySet()) list.add(n);
        Collections.sort(list);
        int res = 0;
        while (orders>0){
            int freq = map.get(list.get(list.size()-1));
            res += calculate(list.get(list.size()-1), freq, list.get(list.size()-2), orders);
            orders = Math.max(0, orders-freq*(list.get(list.size()-1)-list.get(list.size()-2)));
            map.put(list.get(list.size()-2), map.get(list.get(list.size()-2))+freq);
            list.remove(list.size()-1);
        }
        return res;
    }

    private static int calculate(int num, int freq, int next, int rem){
        int max = freq*(num-next);
        if (max<=rem) return freq*((num*(num+1))/2-(next*(next+1))/2);
        int whole = rem/freq;
        int res = freq*((num*(num+1))/2-((num-whole)*(num-whole+1))/2);
        res += (rem%freq)*(num-whole);
        return res;
    }
}