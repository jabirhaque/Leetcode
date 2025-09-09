import java.util.HashMap;
import java.util.Map;

public class SlidingMatch {
    public static void main(String[] args){
        System.out.println("Result: "+solution("ahsjdkfchalsdf", "jsdf"));
    }

    static int solution(String s, String t){
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()){
            if (map.containsKey(c)){
                map.replace(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        Map<Character, Integer> current = new HashMap<>();
        for (int i=0; i<t.length(); i++){
            if (current.containsKey(s.charAt(i))){
                current.replace(s.charAt(i), current.get(s.charAt(i))+1);
            }else{
                current.put(s.charAt(i), 1);
            }
        }
        int i=0;
        int count = 0;
        while (i<=s.length()-t.length()){
            count+=oneDiffer(map, current)?1:0;
            if (current.get(s.charAt(i)) == 1){
                current.remove(s.charAt(i));
            }else{
                current.replace(s.charAt(i), current.get(s.charAt(i))-1);
            }
            if (i+t.length()<s.length()){
                if (current.containsKey(s.charAt(i+t.length()))){
                    current.replace(s.charAt(i+t.length()), current.get(s.charAt(i+t.length()))+1);
                }else{
                    current.put(s.charAt(i+t.length()), 1);
                }
            }
            i++;
        }
        return count;
    }

    static boolean oneDiffer(Map<Character, Integer> map, Map<Character, Integer> current){
        int difference = 0;
        for (int i=0; i<26; i++){
            char c = (char)('a'+i);
            difference+=Math.abs(map.getOrDefault(c, 0)-current.getOrDefault(c, 0));
        }
        System.out.println(difference);
        return difference/2<=1;
    }
}
