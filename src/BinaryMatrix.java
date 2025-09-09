import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BinaryMatrix {

    public static void main(String[] args){
        int[][] grid = new int[][] {{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    private static int min = Integer.MAX_VALUE;

    public static int shortestPathBinaryMatrix(int[][] grid) {
        recursion(grid, List.of(0,0), 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static void recursion(int[][] grid, List<Integer> pos, int count){
        if (grid[pos.get(0)][pos.get(1)] == 1){
            return;
        }
        count++;
        grid[pos.get(0)][pos.get(1)] = 1;
        if (pos.get(0) == grid.length-1 && pos.get(1) == grid.length-1){
            grid[pos.get(0)][pos.get(1)] = 0;
            min = Math.min(min, count);
            return;
        }
        for (int i=-1; i<2; i++){
            for (int j=-1; j<2; j++){
                int r = pos.get(0)+i;
                int c = pos.get(1)+j;
                if (!(i==0 && j==0) && (r>=0 && r<grid.length) && (c>=0 && c<grid.length) && grid[r][c] == 0){
                    recursion(grid, List.of(r, c), count);
                }
            }
        }
        grid[pos.get(0)][pos.get(1)] = 0;
    }
}