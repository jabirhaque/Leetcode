import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MatrixDiagonal {
    public static void main(String[] args){
        System.out.println(sortMatrix(new int[][]{{1,7,3},{9,8,2},{4,5,6}}));
    }

    public static int[][] sortMatrix(int[][] grid) {
        List<List<Integer>> list = new ArrayList<>();
        int iStart = grid.length-1;
        while (iStart >= -grid.length+1){
            List<Integer> l = new ArrayList<>();
            int i = Math.max(0, iStart);
            int j = Math.max(0, -iStart);
            while (i<grid.length && j<grid.length){
                l.add(grid[i][j]);
                i++;
                j++;
            }
            list.add(l);
            iStart--;
        }

        int n = 0;
        iStart = grid.length-1;
        while (n<2*grid.length-1){
            Collections.sort(list.get(n));
            if (n<grid.length){
                Collections.reverse(list.get(n));
            }
            int m=0;
            int i = Math.max(0, iStart);
            int j = Math.max(0, -iStart);
            while (i<grid.length && j<grid.length){
                grid[i][j] = list.get(n).get(m);
                m++;
                i++;
                j++;
            }
            iStart--;
            n++;
        }
        return grid;
    }
}