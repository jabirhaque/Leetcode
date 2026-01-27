import java.util.*;

class PythNode {
    int val;
    int x;
    int y;
    int z;
    List<PythNode> neighbours;
    PythNode(int val){
        this.val = val;
        this.x = Integer.MAX_VALUE;
        this.y = Integer.MAX_VALUE;
        this.z = Integer.MAX_VALUE;
        this.neighbours = new ArrayList<>();
    }
}

class Pythagorian {
    public static void main(String[] args){
        System.out.println(specialNodes(4, new int[][]{{0,1}, {1,2}, {2,3}}, 0,3,2));
    }

    public static int specialNodes(int n, int[][] edges, int x, int y, int z) {
        Map<Integer, PythNode> map = new HashMap<>();
        for (int i=0; i<n; i++) map.put(i, new PythNode(i));
        for (int[] edge: edges){
            PythNode first = map.get(edge[0]);
            PythNode second = map.get(edge[1]);
            first.neighbours.add(second);
            second.neighbours.add(first);
        }
        Queue<PythNode> queue = new LinkedList<>();
        map.get(x).x = 0;
        queue.add(map.get(x));
        while (!queue.isEmpty()){
            PythNode node = queue.poll();
            for (PythNode next: node.neighbours){
                if (1+node.x < next.x){
                    next.x = 1+node.x;
                    queue.add(next);
                }
            }
        }

        map.get(y).y = 0;
        queue.add(map.get(y));
        while (!queue.isEmpty()){
            PythNode node = queue.poll();
            for (PythNode next: node.neighbours){
                if (1+node.y < next.y){
                    next.y = 1+node.y;
                    queue.add(next);
                }
            }
        }

        map.get(z).z = 0;
        queue.add(map.get(z));
        while (!queue.isEmpty()){
            PythNode node = queue.poll();
            for (PythNode next: node.neighbours){
                if (1+node.z < next.z){
                    next.z = 1+node.z;
                    queue.add(next);
                }
            }
        }

        int count = 0;
        for (int i=0; i<n; i++){
            int xVal = map.get(i).x;
            int yVal = map.get(i).y;
            int zVal = map.get(i).z;
            if (xVal*xVal + yVal*yVal == zVal*zVal || xVal*xVal + zVal*zVal == yVal*yVal || yVal*yVal + zVal*zVal == xVal*xVal) count++;
        }

        return count;
    }
}