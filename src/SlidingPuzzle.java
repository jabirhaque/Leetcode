import java.awt.desktop.SystemSleepEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SlidingPuzzle {
    public static void main(String[] args){
        System.out.println(slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    }

    public static int slidingPuzzle(int[][] board) {
        int res = recursion(board, new HashSet<>());
        return res<Integer.MAX_VALUE?res:-1;
    }

    private static int recursion(int[][] board, Set<String> visited){
        String key = "";
        int row=0;
        int column=0;
        for (int i=0; i<2; i++) for (int j=0; j<3; j++){
            key+=board[i][j];
            if (board[i][j] == 0){
                row = i;
                column = j;
            }
        }
        if (key.equals("123450")) return 0;
        if (visited.contains(key)) return Integer.MAX_VALUE;
        visited.add(key);
        int min = Integer.MAX_VALUE;
        if (row == 1){
            board[row][column] = board[row-1][column];
            board[row-1][column] = 0;
            int res = recursion(board, visited);
            if (res < Integer.MAX_VALUE) min = Math.min(min, 1+res);
            board[row-1][column] = board[row][column];
            board[row][column] = 0;
        }
        if (row == 0){
            board[row][column] = board[row+1][column];
            board[row+1][column] = 0;
            int res = recursion(board, visited);
            if (res < Integer.MAX_VALUE) min = Math.min(min, 1+res);
            board[row+1][column] = board[row][column];
            board[row][column] = 0;
        }
        if (column!=0){
            board[row][column] = board[row][column-1];
            board[row][column-1] = 0;
            int res = recursion(board, visited);
            if (res < Integer.MAX_VALUE) min = Math.min(min, 1+res);
            board[row][column-1] = board[row][column];
            board[row][column] = 0;
        }
        if (column!=2){
            board[row][column] = board[row][column+1];
            board[row][column+1] = 0;
            int res = recursion(board, visited);
            if (res < Integer.MAX_VALUE) min = Math.min(min, 1+res);
            board[row][column+1] = board[row][column];
            board[row][column] = 0;
        }
        visited.remove(key);
        return min;
    }
}