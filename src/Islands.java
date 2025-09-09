class Islands {
    public static void main(String[] args){
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int result = numIslands(grid);
        System.out.println(result);
    }
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[0].length; j++){
                if (grid[i][j] == '1'){
                    grid[i][j] = '2';
                    boolean valid = (i==0 || grid[i-1][j]!='2') && (j==0 || grid[i][j-1]!='2');
                    if (valid){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}