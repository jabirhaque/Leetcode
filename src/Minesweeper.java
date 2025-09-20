import java.util.Arrays;

class Minesweeper {
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(updateBoard(new char[][]{
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}
        }, new int[]{3, 0})));
    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        return dfs(board, click[0], click[1]);
    }

    private static char[][] dfs(char[][] board, int i, int j){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != 'M' && board[i][j] != 'E') return board;
        if (board[i][j] == 'M'){
            board[i][j] = 'X';
            return board;
        }
        int count=0;
        for (int m=i-1; m<=i+1; m++){
            for (int n=j-1; n<=j+1; n++){
                if ((m>=0 && m<board.length && n>=0 && n<board[0].length) && (m!=i || n!=j) && board[m][n] == 'M') count++;
            }
        }
        if (count > 0){
            board[i][j] = (char)(count+'0');
            return board;
        }
        board[i][j] = 'B';
        for (int m=i-1; m<=i+1; m++){
            for (int n=j-1; n<=j+1; n++){
                if (m!=i || n!=j){
                    dfs(board, m, n);
                }
            }
        }
        return board;
    }
}