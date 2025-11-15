import java.util.*;

class ComparePref {
    public static void main(String[] args){
        System.out.println(Arrays.toString(longestCommonPrefix(new String[]{"efe","feae","fb"})));
    }

    public static int[] longestCommonPrefix(String[] words) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<words.length; i++){
            List<Integer> list = new ArrayList<>();
            for (int j=i+1; j<i+3 && j<words.length; j++){
                list.add(compare(words[i], words[j]));
            }
            map.put(i, list);
        }
        int[] res = new int[words.length];
        for (int i=0; i<words.length; i++){
            int effected = i-1;
            int max = 0;
            for (int j=0; j<words.length; j++){
                if (j == effected && map.get(j).size()>1) max = Math.max(max, map.get(j).get(1));
                else if (j!=i && j!= effected && !map.get(j).isEmpty()) max = Math.max(max, map.get(j).get(0));
            }
            res[i] = max;
        }
        return res;
    }

    private static int compare(String a, String b){
        int i = 0;
        while (i<a.length() && i<b.length() && a.charAt(i) == b.charAt(i)) i++;
        return i;
    }
}