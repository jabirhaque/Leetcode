class Oranges {
    public static void main(String[] args){
        System.out.println(orangesRotting(new int[][] {{2,1,1},{1,1,0},{0,1,1}}));
    }

    public static int orangesRotting(int[][] grid) {
        return recursion(grid, 0);
    }

    private static int recursion(int[][] grid, int time){
        boolean change=false;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 2){
                    if (i!=0 && grid[i-1][j] == 1){
                        grid[i-1][j] = 2;
                        change = true;
                    }
                    if (i!=grid.length-1 && grid[i+1][j] == 1){
                        grid[i+1][j] = 2;
                        change = true;
                    }
                    if (j!=0 && grid[i][j-1] == 1){
                        grid[i][j-1] = 2;
                        change = true;
                    }
                    if (j!=grid[0].length-1 && grid[i][j+1] == 1){
                        grid[i][j+1] = 2;
                        change = true;
                    }
                }
            }
        }
        if (change){
            return recursion(grid, time+1);
        }
        return time;
    }
}