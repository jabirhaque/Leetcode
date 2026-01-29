import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class StringNode{
    char val;
    Map<StringNode, Integer> neighbours;
    StringNode(char val){
        this.val = val;
        this.neighbours = new HashMap<>();
    }
}

class StringCost {
    public static void main(String[] args){
        minimumCost("abcd", "acbe", new char[]{'a','b','c','c','e','d'}, new char[]{'b','c','b','e','b','e'}, new int[]{2,5,5,1,2,20});
    }

    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long total = 0;
        Map<Character, StringNode> map = new HashMap<>();
        for (int i=0; i<original.length; i++){
            StringNode first = map.getOrDefault(original[i], new StringNode(original[i]));
            map.put(original[i], first);
            StringNode second = map.getOrDefault(changed[i], new StringNode(changed[i]));
            map.put(changed[i], second);
            first.neighbours.put(second, Math.min(cost[i], first.neighbours.getOrDefault(second, Integer.MAX_VALUE)));
        }
        for (int i=0; i<source.length(); i++){
            Map<StringNode, Integer> bfs = new HashMap<>();
            if (!map.containsKey(source.charAt(i)) || !map.containsKey(target.charAt(i))) return -1;
            StringNode first = map.get(source.charAt(i));
            StringNode second = map.get(target.charAt(i));
            Queue<StringNode> queue = new LinkedList<>();
            bfs.put(first, 0);
            while (!queue.isEmpty()){
                StringNode node = queue.poll();
                for (StringNode next: node.neighbours.keySet()){
                    if (bfs.get(node)+node.neighbours.get(next) < bfs.getOrDefault(next, Integer.MAX_VALUE)){
                        bfs.put(next, bfs.get(node)+node.neighbours.get(next));
                        queue.add(next);
                    }
                }
            }
            if (!bfs.containsKey(second)) return -1;
            total += bfs.get(second);
        }
        return total;
    }
}