import java.util.HashMap;
import java.util.Map;

class Vowels {
    public static void main(String[] args){
        System.out.println(findTheLongestSubstring("eleetminicoworoep"));
    }
    public static int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        String bit = "00000";
        Map<String, Integer> index = new HashMap<String, Integer>();
        index.put(bit, 0);
        int max = 0;
        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                bit = bit.substring(0, map.get(s.charAt(i))) + (bit.charAt(map.get(s.charAt(i)))=='0'?'1':'0') + bit.substring(map.get(s.charAt(i))+1);
            }
            index.put(bit, Math.min(index.getOrDefault(bit, Integer.MAX_VALUE), i+1));
            max = Math.max(max, i+1-index.get(bit));
        }
        return max;
    }
}