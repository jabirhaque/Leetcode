import java.util.HashSet;
import java.util.Set;

public class ShortestWayToFormAString {
    public static void main(String[] args){
        System.out.println(solution("abc", "abcbc"));
    }

    public static int solution(String source, String target){
        Set<Character> set = new HashSet<>();
        for (char c: source.toCharArray()) set.add(c);
        for (char c: target.toCharArray()) if (!set.contains(c)) return -1;
        return recursion(source, target, 0, 0);
    }

    private static int recursion(String source, String target, int i, int j){
        if (j == target.length()) return 1;
        if (i == source.length()) return 1 + recursion(source, target, 0, j);
        if (source.charAt(i) == target.charAt(j)) return recursion(source, target, i+1, j+1);
        return recursion(source, target, i+1, j);
    }
}
