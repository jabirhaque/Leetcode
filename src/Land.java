import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Land {

    public static void main(String[] args){
        int[][] grid = new int[][]{{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {
        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 1){
                    queue.add(List.of(i, j));
                }
            }
        }
        int max = 0;
        while (!queue.isEmpty()){
            List<Integer> prev = queue.remove();
            if (prev.get(0)-1>=0 && prev.get(0)-1<grid.length && prev.get(1)>=0 && prev.get(1)<grid[0].length && (grid[prev.get(0)-1][prev.get(1)] == 0 || grid[prev.get(0)][prev.get(1)]+1<grid[prev.get(0)-1][prev.get(1)])){
                grid[prev.get(0)-1][prev.get(1)] = grid[prev.get(0)][prev.get(1)]+1;
                queue.add(List.of(prev.get(0)-1, prev.get(1)));
                max = Math.max(max, grid[prev.get(0)][prev.get(1)]+1);
            }
            if (prev.get(0)+1>=0 && prev.get(0)+1<grid.length && prev.get(1)>=0 && prev.get(1)<grid[0].length && (grid[prev.get(0)+1][prev.get(1)] == 0 || grid[prev.get(0)][prev.get(1)]+1<grid[prev.get(0)+1][prev.get(1)])){
                grid[prev.get(0)+1][prev.get(1)] = grid[prev.get(0)][prev.get(1)]+1;
                queue.add(List.of(prev.get(0)+1, prev.get(1)));
                max = Math.max(max, grid[prev.get(0)][prev.get(1)]+1);
            }
            if (prev.get(0)>=0 && prev.get(0)<grid.length && prev.get(1)-1>=0 && prev.get(1)-1<grid[0].length && (grid[prev.get(0)][prev.get(1)-1] == 0 || grid[prev.get(0)][prev.get(1)]+1<grid[prev.get(0)][prev.get(1)-1])){
                grid[prev.get(0)][prev.get(1)-1] = grid[prev.get(0)][prev.get(1)]+1;
                queue.add(List.of(prev.get(0), prev.get(1)-1));
                max = Math.max(max, grid[prev.get(0)][prev.get(1)]+1);
            }
            if (prev.get(0)>=0 && prev.get(0)<grid.length && prev.get(1)+1>=0 && prev.get(1)+1<grid[0].length && (grid[prev.get(0)][prev.get(1)+1] == 0 || grid[prev.get(0)][prev.get(1)]+1<grid[prev.get(0)][prev.get(1)+1])){
                grid[prev.get(0)][prev.get(1)+1] = grid[prev.get(0)][prev.get(1)]+1;
                queue.add(List.of(prev.get(0), prev.get(1)+1));
                max = Math.max(max, grid[prev.get(0)][prev.get(1)]+1);
            }
        }
        return max-1;
    }
}