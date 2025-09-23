import java.util.*;

class GraphNode{
    int val;
    List<GraphNode> neighbours;
    Integer set;
    boolean visited;
    GraphNode(int val){
        this.val = val;
        this.neighbours = new ArrayList<>();
        this.set = null;
        this.visited = false;
    }
}

class Bipartite {
    public static void main(String[] args){
        System.out.println(isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }

    public static boolean isBipartite(int[][] graph) {
        Map<Integer, GraphNode> map = new HashMap<>();
        for (int i=0; i<graph.length; i++) map.put(i, new GraphNode(i));
        for (int i=0; i<graph.length; i++){
            GraphNode node = map.get(i);
            for (int j: graph[i]){
                GraphNode connect = map.get(j);
                node.neighbours.add(connect);
                connect.neighbours.add(node);
            }
        }
        Queue<GraphNode> queue = new LinkedList<>();
        map.get(0).set = 0;
        queue.add(map.get(0));
        while (!queue.isEmpty()){
            GraphNode node = queue.remove();
            node.visited = true;
            for (GraphNode neighbour: node.neighbours){
                if (neighbour.set == null) neighbour.set = 1-node.set;
                else if (neighbour.set == node.set) return false;
                if (!neighbour.visited) queue.add(neighbour);
            }
        }
        return true;
    }
}