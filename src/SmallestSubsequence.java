import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SmallestSubsequence {
    public static void main(String[] args){
        System.out.println(smallestSubsequence("bdfecedcbfcfeaaffdbaeeabadbbbddddcafdfeeeebfcdabcfaadecddccdefcabedbebbdcbdfefeffcbbeaefaeefeeceadea"));
    }

    public static String smallestSubsequence(String s) {
        List<Set<Character>> list = new ArrayList<>();
        for (int i=s.length()-1; i>=0; i--){
            if (i == s.length()-1){
                Set<Character> set = new HashSet<>();
                set.add(s.charAt(i));
                list.add(set);
            }else{
                Set<Character> set = new HashSet<>(list.get(0));
                set.add(s.charAt(i));
                list.add(0, set);
            }
        }
        Set<Character> set = new HashSet<>(list.get(0));
        Set<Character> included = new HashSet<>();
        int target = set.size();
        int i=0;
        String res = "";
        while (res.length()<target){
            int index = i-1;
            for (int j=i; j<s.length() && compare(set, list.get(j)); j++){
                if (!included.contains(s.charAt(j)) && (index == i-1 || s.charAt(j)<s.charAt(index))) index = j;
            }
            res += s.charAt(index);
            included.add(s.charAt(index));
            set.remove(s.charAt(index));
            i=index+1;
        }
        return res;
    }

    private static boolean compare(Set<Character> a, Set<Character> b){
        for (char c: a) if (!b.contains(c)) return false;
        return true;
    }
}