import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemoParent {
    public static void main(String[] args){
        System.out.println(removeInvalidParentheses("()())()"));
    }

    public static List<String> removeInvalidParentheses(String s) {
        return new ArrayList<>(dp(s, 0, 0, "", -1, new HashSet<>()));
    }

    private static Set<String> dp(String s, int i, int current, String curr, int removals, Set<String> result){
        if (i == s.length()){
            if (current > 0) return result;
            if (!result.isEmpty()){
                if (removals > -1 && removals < s.length()-curr.length()) return result;
                if (removals > -1 && removals > s.length()-curr.length()) result.clear();
            }
            result.add(curr);
            removals = s.length()-curr.length();
            return result;
        }
        dp(s, i+1, current, curr, removals, result);
        if (s.charAt(i) == '(') dp(s, i+1, current+1, curr+'(', removals, result);
        else if (current > 0) dp(s, i+1, current-1, curr+')', removals, result);
        return result;
    }
}