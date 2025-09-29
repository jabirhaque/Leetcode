import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ShortestBinaryMatrix {
    public static void main(String[] args){
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0,0,0},{1,1,0},{1,1,0}}));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dp = new int[grid.length][grid.length];
        for (int[] a: dp) Arrays.fill(a, -1);
        Queue<List<Integer>> queue = new LinkedList<>();
        if (grid[0][0] == 0){
            dp[0][0] = 1;
            queue.add(List.of(0,0));
        }
        while (!queue.isEmpty()){
            List<Integer> curr = queue.remove();
            for (int i=-1; i<2 && (curr.get(0) != grid.length-1 || curr.get(1) != grid.length-1); i++){
                for (int j=-1; j<2; j++){
                    if ((i!=0 || j!=0) && curr.get(0)+i>=0 && curr.get(0)+i<grid.length && curr.get(1)+j>=0 && curr.get(1)+j<grid.length && grid[curr.get(0)+i][curr.get(1)+j] == 0 && (dp[curr.get(0)+i][curr.get(1)+j] == -1 || dp[curr.get(0)][curr.get(1)]+1<dp[curr.get(0)+i][curr.get(1)+j])){
                        dp[curr.get(0)+i][curr.get(1)+j] = dp[curr.get(0)][curr.get(1)]+1;
                        queue.add(List.of(curr.get(0)+i, curr.get(1)+j));
                    }
                }
            }
        }
        return dp[grid.length-1][grid.length-1];
    }
}