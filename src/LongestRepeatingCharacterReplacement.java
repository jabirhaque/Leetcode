import java.util.HashMap;
import java.util.Map;

class LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        System.out.println(characterReplacement("AABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        map.put(s.charAt(0), 1);
        while (r<s.length()){
            if ((r-l+1)-getMax(map) <= k){
                max = Math.max(max, r-l+1);
                r++;
                if (r<s.length() && map.containsKey(s.charAt(r))){
                    map.replace(s.charAt(r), map.get(s.charAt(r))+1);
                }else if (r<s.length()){
                    map.put(s.charAt(r), 1);
                }
            }else{
                if (map.get(s.charAt(l)) == 1){
                    map.remove(s.charAt(l));
                }else{
                    map.replace(s.charAt(l), map.get(s.charAt(l))-1);
                }
                l++;
            }
        }
        return max;
    }

    private static int getMax(Map<Character, Integer> map){
        int max = 0;
        for (int i=65; i<91; i++){
            if (map.containsKey((char)i)){
                max = Math.max(max, map.get((char)i));
            }
        }
        return max;
    }
}