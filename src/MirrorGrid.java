class MirrorGrid {
    public static void main(String[] args){
        System.out.println(uniquePaths(new int[][]{{0,1,0},{0,0,1},{1,0,0}}));
    }

    public static int uniquePaths(int[][] grid) {
        return recursion(grid, 0, 0);
    }

    private static int recursion(int[][] grid, int i, int j){
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if (i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }
        int res = recursion(grid, i+1, j) + recursion(grid, i, j+1);
        return res;
    }
}