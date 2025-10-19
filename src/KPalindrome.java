import java.util.HashMap;
import java.util.Map;

class KPalindrome {
    public static void main(String[] args){
        System.out.println(canConstruct("qlkzenwmmnpkopu", 15));
    }

    public static boolean canConstruct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0)+1);
        int even = 0;
        int odd = 0;
        for (char c: map.keySet()){
            even += map.get(c)/2;
            if (map.get(c)%2==1) odd++;
        }
        if (odd>k) return false;
        return check(even, odd, k);
    }

    private static boolean check(int a, int b, int k){
        if (a+b>=k) return true;
        int diff = k-(a+b);
        return a>=diff;
    }
}