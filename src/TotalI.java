class TotalI {
    public static void main(String[] args){
        System.out.println(countIslands(new int[][]{
                {16, 0},
                {0, 0},
                {0, 0},
                {0, 3},
                {9, 10}
        }, 13));
    }

    public static int countIslands(int[][] grid, int k) {
        int count = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] > 0){
                    int total = total(grid, i, j);
                    if (total%k == 0) count++;
                }
            }
        }
        return count;
    }

    private static int total(int[][] grid, int i, int j){
        int total = grid[i][j];
        grid[i][j] = 0;
        if (i-1>=0 && grid[i-1][j] > 0) total += total(grid, i-1, j);
        if (i+1<grid.length && grid[i+1][j] > 0) total += total(grid, i+1, j);
        if (j-1>0 && grid[i][j-1] > 0) total += total(grid, i, j-1);
        if (j+1<=grid[0].length && grid[i][j+1] > 0) total += total(grid, i, j+1);
        return total;
    }
}