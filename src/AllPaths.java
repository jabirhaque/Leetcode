import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AllPathNode{
    int val;
    List<AllPathNode> neighbours;
    AllPathNode(int val){
        this.val = val;
        this.neighbours = new ArrayList<>();
    }
}

class AllPaths {
    public static void main(String[] args){
        System.out.println(allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, AllPathNode> map = new HashMap<>();
        for (int i=0; i<graph.length; i++){
            AllPathNode first = map.getOrDefault(i, new AllPathNode(i));
            map.put(i, first);
            for (int j: graph[i]){
                AllPathNode second = map.getOrDefault(j, new AllPathNode(j));
                map.put(j, second);
                first.neighbours.add(second);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(map.get(0), map.get(map.size()-1), new ArrayList<>(), result);
        return result;

    }

    private static void dfs(AllPathNode node, AllPathNode target, List<Integer> current, List<List<Integer>> result){
        current.add(node.val);
        if (node == target){
            List<Integer> list = new ArrayList<>(current);
            result.add(list);
            current.remove(current.size()-1);
            return;
        }
        for (AllPathNode next: node.neighbours) dfs(next, target, current, result);
        current.remove(current.size()-1);
    }
}