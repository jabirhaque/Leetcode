import java.util.HashMap;
import java.util.Map;

class Change {
    public static void main(String[] args){
        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));
    }
    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(20, 0);
        map.put(10, 0);
        map.put(5, 0);
        for (int bill: bills){
            int change = bill-5;
            int twenties = Math.max(change/20, map.get(20));
            change -= twenties*20;
            map.put(20, map.get(20)-twenties);
            int tens = Math.max(change/10, map.get(10));
            change -= tens*10;
            map.put(10, map.get(10)-tens);
            int fives = Math.max(change/5, map.get(5));
            change -= fives*5;
            map.put(5, map.get(5)-fives);
            if (change != 0) return false;
            map.put(bill, map.get(bill)+1);
        }
        return true;
    }
}