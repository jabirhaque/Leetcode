import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Rules {
    public static void main(String[] args){
        System.out.println(eval(List.of("Cb$b-C?C", "%$%!&c&%", "£B+£+B.aC", "!#%£-B#/@", "!b&aC%+")));
    }

    private static List<Boolean> eval(List<String> list){
        List<Boolean> res = new ArrayList<>();
        for (String str: list) res.add(valid(str));
        return res;
    }

    private static boolean valid(String str){
        Set<Character> smallSet = Set.of('a', 'b', 'c');
        Set<Character> largeSet = Set.of('A', 'B', 'C');
        Set<Character> punctuationSet = Set.of('.', ';', ',', '!', '?');
        Set<Character> specialSet = Set.of('$', '&', '@', '£', '%', '#');
        Set<Character> operatorsSet = Set.of('+', '-', '/');

        Set<Character> used = new HashSet<>();

        int special = 0;
        int operators = 0;
        int punctuation = 0;
        int small = 0;
        for (char c: str.toCharArray()){
//            if (specialSet.contains(c)){
//                if (used.contains(c)) return false;
//                special++;
//                used.add(c);
//            }
            if (operatorsSet.contains(c)) operators++;
            if (punctuationSet.contains(c)) punctuation++;
            if (smallSet.contains(c)) small++;
        }
        //if (special>2) return false;
        if (small<1) return false;
        if (operators>2) return false;
        if (punctuation>1) return false;
        if (str.length()<7) return false;
        return true;
    }
}
