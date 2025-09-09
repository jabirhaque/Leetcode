import java.util.*;

class Lock {
    public static void main(String[] args){
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    }
    public static int openLock(String[] deadends, String target) {
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('0', List.of('9', '1'));
        map.put('1', List.of('0', '2'));
        map.put('2', List.of('1', '3'));
        map.put('3', List.of('2', '4'));
        map.put('4', List.of('3', '5'));
        map.put('5', List.of('4', '6'));
        map.put('6', List.of('5', '7'));
        map.put('7', List.of('6', '8'));
        map.put('8', List.of('7', '9'));
        map.put('9', List.of('8', '0'));
        Set<String> deadSet = new HashSet<>();
        for (String d: deadends){
            deadSet.add(d);
        }
        int res = recursion("0000", target, deadSet, new HashSet<>(), map, new HashMap<>());
        return res >= 10000?-1:res;
    }

    private static int recursion(String lock, String target, Set<String> deadends, Set<String> path, Map<Character, List<Character>> map, Map<String, Integer> dp){
        if (dp.containsKey(lock)){
            return dp.get(lock);
        }
        if (lock.equals(target)){
            return 0;
        }
        if (deadends.contains(lock)){
            return 10000;
        }
        if (path.contains(lock)){
            return 10000;
        }
        path.add(lock);
        int min = 10000;
        for (int i=0; i<4; i++){
            List<Character> rotates = map.get(lock.charAt(i));
            min = Math.min(min, 1+recursion(lock.substring(0, i)+rotates.get(0)+lock.substring(i+1, 4), target, deadends, path, map, dp));
            min = Math.min(min, 1+recursion(lock.substring(0, i)+rotates.get(1)+lock.substring(i+1, 4), target, deadends, path, map, dp));
        }
        dp.put(lock, min);
        path.remove(lock);
        return min;
    }
}