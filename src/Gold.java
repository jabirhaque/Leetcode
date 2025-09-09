import java.util.HashMap;
import java.util.Map;

public class Gold {
    public static void main(String[] args){
        System.out.println(getMaximumGold(new int[][] {{0,6,0},{5,8,7},{0,9,0}}));
    }

    public static int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] != 0){
                    max = Math.max(max, recursion(grid, i, j, 0));
                }
            }
        }
        return max;
    }

    private static int recursion(int[][] grid, int i, int j, int current){
        current+=grid[i][j];
        int val = grid[i][j];
        grid[i][j] = 0;
        int max = current;
        if (i>0 && grid[i-1][j] != 0){
            max = Math.max(max, recursion(grid, i-1, j, current));
        }
        if (i<grid.length-1 && grid[i+1][j] != 0){
            max = Math.max(max, recursion(grid, i+1, j, current));
        }
        if (j>0 && grid[i][j-1] != 0){
            max = Math.max(max, recursion(grid, i, j-1, current));
        }
        if (j<grid[0].length-1 && grid[i][j+1] != 0){
            max = Math.max(max, recursion(grid, i, j+1, current));
        }
        grid[i][j] = val;
        return max;
    }
}
