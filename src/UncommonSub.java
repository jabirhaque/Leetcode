import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UncommonSub {
    public static void main(String[] args){
        System.out.println(findLUSlength(new String[]{"aabbcc", "aabbcc","b"}));
    }

    public static int findLUSlength(String[] strs) {
        Map<Integer, Set<String>> map = new HashMap<>();
        for (int i=0; i<strs.length; i++){
            map.put(i, new HashSet<>());
            backtrack(strs, i, map, new int[strs[i].length()], 0);
        }
        int max = -1;
        for (int i=0; i<strs.length; i++){
            for (String str: map.get(i)){
                boolean valid = true;
                for (int j=0; j<strs.length; j++){
                    if (i == j) continue;
                    if (map.get(j).contains(str)) valid = false;
                }
                if (valid) max = Math.max(max, str.length());
            }
        }
        return max;
    }

    private static Map<Integer, Set<String>> backtrack(String[] strs, int i, Map<Integer, Set<String>> map, int[] arr, int j){
        if (j == arr.length){
            StringBuilder sb = new StringBuilder();
            for (int k=0; k<arr.length; k++){
                if (arr[k] == 1) sb.append(strs[i].charAt(k));
            }
            map.get(i).add(sb.toString());
            return map;
        }
        arr[j] = 0;
        backtrack(strs, i, map, arr, j+1);
        arr[j] = 1;
        backtrack(strs, i, map, arr, j+1);
        return map;
    }
}