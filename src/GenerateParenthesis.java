import java.util.*;

class GenerateParenthesis {
    public static void main(String[] args){
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> dupes = recursion(n, new HashMap<>());
        Set<String> set = new HashSet<>();
        List<String> results = new ArrayList<>();
        for (String d: dupes){
            if (!set.contains(d)){
                set.add(d);
                results.add(d);
            }
        }
        return results;
    }

    private static List<String> recursion(int n, Map<Integer, List<String>> map){
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n == 1){
            return List.of("()");
        }
        List<String> list = new ArrayList<>();
        for (int i=1; i<n; i++){
            List<String> first = recursion(i, map);
            List<String> second = recursion(n-i, map);
            for (String f: first){
                for (String s: second){
                    list.add(f+s);
                }
            }
        }
        List<String> below = recursion(n-1, map);
        for (String b: below){
            list.add("("+b+")");
        }
        map.put(n, list);
        return list;
    }
}