import java.util.*;

class Swim {
    public static void main(String[] args){
        Swim swim = new Swim();
        int[][] array = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        swim.swimInWater(array);
    }

    public int swimInWater(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(0, grid[0][0]));
        while (!queue.isEmpty()){
            List<Integer> curr = queue.poll();
            int i = curr.get(0)/grid.length;
            int j = curr.get(0)%grid.length;
            int t = curr.get(1);
            if (map.getOrDefault(curr.get(0), Integer.MAX_VALUE) <= t) continue;
            map.put(curr.get(0), t);

            if (i>0) queue.add(List.of(curr.get(0)-grid.length, Math.max(t, grid[i-1][j])));
            if (i<grid.length-1) queue.add(List.of(curr.get(0)+grid.length, Math.max(t, grid[i+1][j])));
            if (j>0) queue.add(List.of(curr.get(0)-1, Math.max(t, grid[i][j-1])));
            if (j<grid[0].length-1) queue.add(List.of(curr.get(0)+1, Math.max(t, grid[i][j+1])));
        }
        return map.get(grid.length*grid[0].length-1);
    }
}