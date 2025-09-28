import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class SnakesAndLadders {
    public static void main(String[] args){
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board));
    }

    public static int snakesAndLadders(int[][] board) {
        int[] dp = new int[board.length*board.length+1];
        Arrays.fill(dp, -1);
        dp[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()){
            int last = queue.remove();
            for (int i=1; i <= 6 && last+i< dp.length; i++){
                int next = last + i;
                int[] coordinates = find(next, board);
                if (board[coordinates[0]][coordinates[1]] > -1) next = board[coordinates[0]][coordinates[1]];
                if (dp[next] < 0 || dp[last]+1 < dp[next]){
                    dp[next] = dp[last]+1;
                    queue.add(next);
                }
            }
        }
        return dp[dp.length-1];
    }

    private static int[] find(int n, int[][] board){
        int i = (n-1)/board.length;
        int j = (n-1)%board.length;
        return new int[]{board.length-1-i, i%2==0?j:board.length-1-j};
    }
}