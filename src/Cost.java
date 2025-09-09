import java.util.HashMap;
import java.util.Map;

class Node{
    int val;
    boolean visited;
    Map<Node, Integer> neighbours;
    Map<Node, Integer> reverse;
    boolean reverseValid;
    Node(int val){
        this.val = val;
        this.visited = false;
        this.neighbours = new HashMap<>();
        this.reverse = new HashMap<>();
        this.reverseValid = true;
    }
}

class Cost {

    public static void main(String[] args){
        System.out.println(minCost(4, new int[][]{{0, 2, 2}, {0, 1, 24}, {3, 1, 8}, {1, 0, 15}, {3, 0, 23}, {2, 0, 24}}));
    }

    public static int minCost(int n, int[][] edges) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i=0; i<n; i++){
            map.put(i, new Node(i));
        }
        for (int[] edge: edges){
            Node first = map.get(edge[0]);
            Node second = map.get(edge[1]);
            first.neighbours.put(second, edge[2]);
            second.reverse.put(first, edge[2]*2);
        }
        int res = recursion(map.get(0), map.get(n-1));
        return res>=100000?-1:res;
    }

    private static int recursion(Node node, Node target){
        if (node == target){
            return 0;
        }
        if (node.visited){
            node.visited = false;
            return 100000;
        }
        node.visited = true;
        int min = 100000;
        for (Node child: node.neighbours.keySet()){
            min = Math.min(min, node.neighbours.get(child)+recursion(child, target));
        }
        if (node.reverseValid){
            node.reverseValid = false;
            for (Node child: node.reverse.keySet()){
                min = Math.min(min, node.reverse.get(child)+recursion(child, target));
            }
            node.reverseValid = true;
        }
        node.visited = false;
        return min;
    }
}