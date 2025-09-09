class Area {
    public static void main(String[] args){
        System.out.println(minimumArea(new int[][]{{0,1,0}, {1,0,1}}));
    }

    public static int minimumArea(int[][] grid) {
        int firstVertical = Integer.MAX_VALUE;
        int lastVertical = -1;
        int firstHorizontal = Integer.MAX_VALUE;
        int lastHorizontal = -1;
        for (int i=0; i<grid.length; i++){
            for (int j=0; j<grid[i].length; j++){
                if (grid[i][j] == 1){
                    firstVertical = Math.min(firstVertical, i);
                    lastVertical = Math.max(lastVertical, i);
                    firstHorizontal = Math.min(firstHorizontal, j);
                    lastHorizontal = Math.max(lastHorizontal, j);
                }
            }
        }
        return (lastVertical-firstVertical+1)*(lastHorizontal-firstHorizontal+1);
    }
}