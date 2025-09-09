import java.util.HashMap;
import java.util.Map;

class L395 {
    public static void main(String[] args){
        System.out.println(longestSubstring("aaabb", 3));
    }
    public static int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()){
            if (map.containsKey(c)){
                map.replace(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        int max = 0;
        boolean flag = true;
        for (char c: map.keySet()){
            if (map.get(c)<k){
                flag = false;
                for (String str: s.split(String.valueOf(c))){
                    max = Math.max(max, longestSubstring(str, k));
                }
            }
        }
        if (flag){
            return s.length();
        }
        return max;
    }
}