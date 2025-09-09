import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AnagramsInString {
    public static void main(String[] args){
        System.out.println(findAnagrams("ababababab", "aab"));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length()>s.length()){
            return List.of();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c: p.toCharArray()){
            if (map.containsKey(c)){
                map.replace(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i=0; i<p.length(); i++){
            if (windowMap.containsKey(s.charAt(i))){
                windowMap.replace(s.charAt(i), windowMap.get(s.charAt(i))+1);
            }else{
                windowMap.put(s.charAt(i), 1);
            }
        }
        for (int i=0; i<=s.length()-p.length(); i++){
            if (windowMap.equals(map)){
                res.add(i);
            }
            if (windowMap.get(s.charAt(i)) == 1){
                windowMap.remove(s.charAt(i));
            }else{
                windowMap.replace(s.charAt(i), windowMap.get(s.charAt(i))-1);
            }
            if (i+p.length() < s.length() && windowMap.containsKey(s.charAt(i+p.length()))){
                windowMap.replace(s.charAt(i+p.length()), windowMap.get(s.charAt(i+p.length()))+1);
            }else if (i+p.length() < s.length()){
                windowMap.put(s.charAt(i+p.length()), 1);
            }
        }
        return res;
    }
}