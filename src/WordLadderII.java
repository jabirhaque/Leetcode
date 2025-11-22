import java.util.*;

class WordLadderII {
    public static void main(String[] args){
        System.out.println(findLadders("hit", "cog", List.of("hot","dot","dog","lot","log","cog")));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<List<String>>> map = new HashMap<>();
        List<String> l = new ArrayList<>(List.of(beginWord));
        List<List<String>> list = new ArrayList<>(List.of(l));
        map.put(beginWord, list);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()){
            String prev = queue.remove();
            if (prev.equals(endWord)) continue;
            for (String next: wordList){
                if (oneLetter(prev, next)){
                    if (map.containsKey(next)){
                        int prevBest = map.get(prev).get(0).size()+1;
                        int nextBest = map.get(next).get(0).size();
                        if (prevBest>nextBest) continue;
                        if (prevBest<nextBest) map.put(next, new ArrayList<>());
                        for (List<String> prevlist: map.get(prev)){
                            List<String> newList = new ArrayList<>(prevlist);
                            newList.add(next);
                            map.get(next).add(newList);
                        }
                    }else{
                        map.put(next, new ArrayList<>());
                        for (List<String> prevlist: map.get(prev)){
                            List<String> newList = new ArrayList<>(prevlist);
                            newList.add(next);
                            map.get(next).add(newList);
                        }
                    }
                    queue.add(next);
                }
            }
        }
        return map.getOrDefault(endWord, new ArrayList<>());
    }

    private static boolean oneLetter(String a, String b){
        int count = 0;
        for (int i=0; i<a.length(); i++){
            if (a.charAt(i)!=b.charAt(i)){
                if (count==1){return false;}
                count++;
            }
        }
        return count == 1;
    }
}