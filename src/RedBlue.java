import java.util.*;

class RedBlueNode{
    int val;
    List<RedBlueNode> reds;
    List<RedBlueNode> blues;
    RedBlueNode(int val){
        this.val = val;
        this.reds = new ArrayList<>();
        this.blues = new ArrayList<>();
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class RedBlue {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, RedBlueNode> map = new HashMap<>();
        for (int i=0; i<n; i++) map.put(i, new RedBlueNode(i));
        for (int[] red: redEdges){
            RedBlueNode first = map.get(red[0]);
            RedBlueNode second = map.get(red[1]);
            first.reds.add(second);
        }
        for (int[] blue: blueEdges){
            RedBlueNode first = map.get(blue[0]);
            RedBlueNode second = map.get(blue[1]);
            first.blues.add(second);
        }
        int[] redFirst = redFirst(map, n);
        int[] blueFirst = blueFirst(map, n);
        return squash(redFirst, blueFirst);
    }

    private int[] squash(int[] a, int[] b){
        for (int i=0; i<a.length; i++){
            if (a[i] == -1 && b[i] == -1){
                continue;
            }else if (a[i] == -1){
                a[i] = b[i];
            }else if (b[i] != -1){
                a[i] = Math.min(a[i], b[i]);
            }
        }
        return a;
    }

    private int[] redFirst(Map<Integer, RedBlueNode> map, int n){
        int[][] dp = new int[2][n];
        for (int[] a: dp) Arrays.fill(a, -1);
        dp[0][0] = 0;
        dp[1][0] = 0;
        Queue<Pair<RedBlueNode, Boolean>> queue = new LinkedList<>();
        queue.add(new Pair(map.get(0), true));
        while (!queue.isEmpty()){
            Pair<RedBlueNode, Boolean> prevPair = queue.remove();
            RedBlueNode prev = prevPair.getKey();
            if (prevPair.getValue()){
                for (RedBlueNode next: prev.reds){
                    if (dp[0][next.val] == -1 || dp[1][prev.val]+1<dp[0][next.val]){
                        dp[0][next.val] = dp[1][prev.val]+1;
                        queue.add(new Pair(next, false));
                    }
                }
            }else{
                for (RedBlueNode next: prev.blues){
                    if (dp[1][next.val] == -1 || dp[0][prev.val]+1<dp[1][next.val]){
                        dp[1][next.val] = dp[0][prev.val]+1;
                        queue.add(new Pair(next, true));
                    }
                }
            }
        }
        return squash(dp[0], dp[1]);
    }

    private int[] blueFirst(Map<Integer, RedBlueNode> map, int n){
        int[][] dp = new int[2][n];
        for (int[] a: dp) Arrays.fill(a, -1);
        dp[0][0] = 0;
        dp[1][0] = 0;
        Queue<Pair<RedBlueNode, Boolean>> queue = new LinkedList<>();
        queue.add(new Pair(map.get(0), false));
        while (!queue.isEmpty()){
            Pair<RedBlueNode, Boolean> prevPair = queue.remove();
            RedBlueNode prev = prevPair.getKey();
            if (prevPair.getValue()){
                for (RedBlueNode next: prev.reds){
                    if (dp[0][next.val] == -1 || dp[1][prev.val]+1<dp[0][next.val]){
                        dp[0][next.val] = dp[1][prev.val]+1;
                        queue.add(new Pair(next, false));
                    }
                }
            }else{
                for (RedBlueNode next: prev.blues){
                    if (dp[1][next.val] == -1 || dp[0][prev.val]+1<dp[1][next.val]){
                        dp[1][next.val] = dp[0][prev.val]+1;
                        queue.add(new Pair(next, true));
                    }
                }
            }
        }
        return squash(dp[0], dp[1]);
    }
}