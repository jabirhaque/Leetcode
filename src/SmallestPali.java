import java.util.*;

class SmallestPali {
    public static void main(String[] args){
        System.out.println(lexPalindromicPermutation("a","b"));
    }

    public static String lexPalindromicPermutation(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            targetMap.put(target.charAt(i), targetMap.getOrDefault(target.charAt(i), 0)+1);
        }
        Map<Character, Integer> evens = new HashMap<>();
        Map<Character, Integer> odds = new HashMap<>();
        for (char c: map.keySet()){
            if (map.get(c)/2>0){
                evens.put(c, map.get(c)/2);
            }
            if (map.get(c)%2>0){
                odds.put(c, 1);
            }
        }
        if ((s.length() == 1 && s.equals(target)) || odds.size()>1) return "";
        String bigger = smallest(evens, odds, target);
        if (bigger.equals("") || bigger.compareTo(target) < 1) return "";
        return bigger;
    }

    private static String smallest(Map<Character, Integer> evens, Map<Character, Integer> odds, String target){
        List<Character> list = new ArrayList<>(evens.keySet());
        Collections.sort(list);
        String half = "";
        boolean bigger = false;
        for (int i=0; i<target.length()/2; i++){
            int index = Collections.binarySearch(list, target.charAt(i));
            if (index<0){
                index = -(1+index);
                bigger = true;
            }
            else if (i == target.length()/2-2){
                if (evens.containsKey(target.charAt(i)) && evens.containsKey(target.charAt(i+1))) index++;
            }
            if (bigger) index = 0;
            if (index==list.size()) return "";
            half += list.get(index);
            if (evens.get(list.get(index)) == 1){
                evens.remove(list.get(index));
                list.remove(index);
            }
            else evens.put(list.get(index), evens.get(list.get(index))-1);
        }
        String reverse = reverse(half);
        for (char c: odds.keySet()) half += c;
        return half+reverse;
    }

    private static  String reverse(String half){
        String res = "";
        for (char c: half.toCharArray()) res = c+res;
        return res;
    }
}