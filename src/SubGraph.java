import java.util.*;

class SubGraphNode{
    int index;
    int val;
    SubGraphNode parent;
    Integer max;
    List<SubGraphNode> children;
    Map<SubGraphNode, Boolean> used;
    Map<SubGraphNode, Integer> associate;
    SubGraphNode(int index, int val){
        this.index = index;
        this.val = val;
        this.parent = null;
        this.max = null;
        this.children = new ArrayList<>();
        this.used = new HashMap<>();
        this.associate = new HashMap<>();
    }
}

class SubGraph {
    public static void main(String[] args){
        System.out.println(Arrays.toString(maxSubgraphScore(3, new int[][]{{0, 2}, {1, 2}}, new int[]{1, 1, 1})));
    }

    public static int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        Map<Integer, SubGraphNode> map = new HashMap<>();
        for (int i=0; i<n; i++) map.put(i, new SubGraphNode(i, good[i]==1?1:-1));
        for (int[] edge: edges){
            SubGraphNode first = map.get(edge[0]);
            SubGraphNode second = map.get(edge[1]);
            first.children.add(second);
            second.parent = first;
        }
        for (int i=0; i<n; i++){
            if (map.get(i).parent == null) {
                dfs(map.get(i));
                parent(map.get(i));
                break;
            }
        }
        int[] res = new int[n];
        for (int i=0; i<n; i++){
            res[i] = map.get(i).max;
        }
        return res;
    }

    private static int dfs(SubGraphNode node){
        if (node.max != null) return node.max;
        node.max = node.val;
        for (SubGraphNode child: node.children){
            int childScore = dfs(child);
            if (childScore>0){
                node.max += childScore;
                node.used.put(child, true);
            }else node.used.put(child, false);
        }
        return node.max;
    }

    private static void parent(SubGraphNode node){
        if (node.parent != null){
            node.max += Math.max(node.parent.associate.get(node), 0);
        }
        for (SubGraphNode child: node.children){
            node.associate.put(child, node.used.get(child)?node.max-dfs(child):node.max);
        }
        for (SubGraphNode child: node.children) parent(child);
    }
}