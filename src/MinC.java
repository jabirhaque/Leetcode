import java.util.HashSet;
import java.util.Set;

class MinC {
    public static void main(String[] args){
        System.out.println(minCostConnectPoints(new int[][]{
                {2, -3},
                {-17, -8},
                {13, 8},
                {-17, -15}
        }));
    }

    public static int minCostConnectPoints(int[][] points) {
        if (points.length <= 1) return 0;
        int cost = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<points.length; i++){
            if (set.contains(i)) continue;
            int closest = -1;
            for (int j=0; j<points.length; j++){
                if (j==i) continue;
                if (closest == -1 || Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]) < Math.abs(points[i][0]-points[closest][0])+Math.abs(points[i][1]-points[closest][1])) closest = j;
            }
            cost += Math.abs(points[i][0]-points[closest][0])+Math.abs(points[i][1]-points[closest][1]);
            set.add(i);
            set.add(closest);
        }
        return cost;
    }
}