import java.util.*;

class Hats {

    public static void main(String[] args){
        System.out.println(numberWays(List.of(List.of(3,5,1),List.of(3,5))));
    }

    public static int numberWays(List<List<Integer>> hats) {
        String str = "";
        String target = "";
        for (int i=0; i<hats.size(); i++){
            str += '1';
            target += '0';
        }
        List<Set<Integer>> sets = new ArrayList<>();
        for (List<Integer> list: hats){
            sets.add(new HashSet<>(list));
        }
        List<List<Integer>> people = new ArrayList<>();
        for (int i=1; i<=40; i++){
            List<Integer> list = new ArrayList<>();
            for (int j=0; j<sets.size(); j++){
                if (sets.get(j).contains(i)) list.add(j);
            }
            people.add(list);
        }
        return dp(str,  target,0, people, new HashMap<>());
    }

    private static int dp(String str, String target, int i, List<List<Integer>> people, Map<String, Integer> map){
        String key = str + ',' + target;
        if (map.containsKey(key)) return map.get(key);
        if (i == people.size()){
            if (str.equals(target)) return 1;
            return 0;
        }
        int count = dp(str, target, i+1, people, map);
        for (int j: people.get(i)){
            if (str.charAt(j) == '1'){
                String newStr = str.substring(0, j)+'0'+str.substring(j+1);
                count += dp(newStr, target, i+1, people, map);
            }
        }
        map.put(key, count);
        return count;
    }
}