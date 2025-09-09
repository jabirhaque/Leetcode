import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
    public static void main(String[] args){
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> mapt = new HashMap<>();
        for (char c: t.toCharArray()){
            if (mapt.containsKey(c)){
                mapt.replace(c, mapt.get(c)+1);
            }else{
                mapt.put(c, 1);
            }
        }
        Map<Character, Integer> maps = new HashMap<>();
        int l=0;
        int r=0;
        if (mapt.containsKey(s.charAt(r))){
            maps.put(s.charAt(r), 1);
        }
        int min = Integer.MAX_VALUE;
        String result = "";
        while (r<s.length()){
            int compare = equals(maps, mapt);
            if (compare > -1){
                if (r-l+1<min){
                    result = s.substring(l, r+1);
                    min = r-l+1;
                }
                if (maps.containsKey(s.charAt(l)) && maps.get(s.charAt(l)) == 1){
                    maps.remove(s.charAt(l));
                }else if (maps.containsKey(s.charAt(l))){
                    maps.replace(s.charAt(l), maps.get(s.charAt(l))-1);
                }
                l++;
            }else{
                r++;
                if (r<s.length()){
                    if (maps.containsKey(s.charAt(r))){
                        maps.replace(s.charAt(r), maps.get(s.charAt(r))+1);
                    }else if (mapt.containsKey(s.charAt(r))){
                        maps.put(s.charAt(r), 1);
                    }
                }
            }
        }
        return result;
    }

    private static int equals(Map<Character, Integer> maps, Map<Character, Integer> mapt){
        if (mapt.equals(maps)){
            return 0;
        }
        for (char c: mapt.keySet()){
            if (!maps.containsKey(c) || maps.get(c) < mapt.get(c)){
                return -1;
            }
        }
        return 1;
    }
}