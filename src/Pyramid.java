import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pyramid {
    public static void main(String[] args){
        System.out.println(pyramidTransition("ABCD", List.of("ABC","BCA","CDA","ABD","BCE","CDF","DEA","EFF","AFF")));
    }

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        return dfs(bottom, "", allowed, new HashSet<>());
    }

    private static boolean dfs(String base, String current, List<String> allowed, Set<String> set){
        if (set.contains(base)) return false;
        if (base.length() == 1) return true;
        if (current.length() == base.length()-1) return dfs(current, "", allowed, set);//memoise
        for (String valid: allowed) if (base.charAt(current.length()) == valid.charAt(0) && base.charAt(current.length()+1) == valid.charAt(1) && dfs(base, current+valid.charAt(2), allowed, set)) return true;
        set.add(base);
        return false;
    }
}