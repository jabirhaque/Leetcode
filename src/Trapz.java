import java.util.*;

class Trapz {
    public static void main(String[] args){
        System.out.println(countTrapezoids(new int[][]{
                {1, 0},
                {2, 0},
                {3, 0},
                {2, 2},
                {3, 2}
        }));
    }

    public static  int countTrapezoids(int[][] points) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point: points){
            map.put(point[1], map.getOrDefault(point[0], 0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int below = 0;
        for (int i: list){
            count += (map.get(i)*(map.get(i)-1)/2)*below;
            below += map.get(i)*(map.get(i)-1)/2;
        }
        return count;
    }
}