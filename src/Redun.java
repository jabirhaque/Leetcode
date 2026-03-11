import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RedunNode{
    int val;
    int parents;
    List<RedunNode> children;
    boolean visited;
    RedunNode(int val){
        this.val = val;
        this.parents = 0;
        this.children = new ArrayList<>();
        this.visited = false;
    }
}

class Redun {
    public static void main(String[] args){
        Redun redun = new Redun();
        int[][] edges = new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}};
        System.out.println(redun.findRedundantDirectedConnection(edges));
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int count = 0;
        for (int[] edge: edges) count = Math.max(count, Math.max(edge[0], edge[1]));
        for (int i=edges.length-1; i>=0; i--){
            if (brute(edges, i, count)) return edges[i];
        }
        return new int[2];
    }

    private boolean brute(int[][] edge, int ignore, int count){
        Map<Integer, RedunNode> map = new HashMap<>();
        for (int i=0; i<edge.length; i++){
            if (i == ignore) continue;
            RedunNode parent = map.getOrDefault(edge[i][0], new RedunNode(edge[i][0]));
            map.put(edge[i][0], parent);
            RedunNode child = map.getOrDefault(edge[i][1], new RedunNode(edge[i][1]));
            map.put(edge[i][1], child);
            parent.children.add(child);
            child.parents++;
        }
        for (int i: map.keySet()){
            if (map.get(i).parents > 1) return false;
            if (map.get(i).parents == 1) continue;
            return traverse(map.get(i)) == count;
        }
        return false;
    }

    private int traverse(RedunNode node){
        if (node.visited) return -1;
        node.visited = true;
        int total = 1;
        for (RedunNode next: node.children){
            int res = traverse(next);
            if (res == -1) return -1;
            total += res;
        }
        return total;
    }
}