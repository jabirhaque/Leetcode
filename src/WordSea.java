public class WordSea {
    public static void main(String[] args){
        System.out.println(exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i=0; i<board.length; i++) for (int j=0; j<board[0].length; j++) if (board[i][j] == word.charAt(0)){
            visited[i][j] = 1;
            if (valid(board, word, i, j, 0, visited)) return true;
            visited[i][j] = 0;
        }
        return false;
    }

    private static boolean valid(char[][] board, String word, int i, int j, int k, int[][] visited){
        if (k == word.length()-1) return true;
        if (i-1>=0 && board[i-1][j] == word.charAt(k+1) && visited[i-1][j] != 1){
            visited[i-1][j] = 1;
            if (valid(board, word, i-1, j, k+1, visited)) return true;
            visited[i-1][j] = 0;
        }
        if (i+1<board.length && board[i+1][j] == word.charAt(k+1) && visited[i+1][j] != 1){
            visited[i+1][j] = 1;
            if (valid(board, word, i+1, j, k+1, visited)) return true;
            visited[i+1][j] = 0;
        }
        if (j-1>=0 && board[i][j-1] == word.charAt(k+1) && visited[i][j-1] != 1){
            visited[i][j-1] = 1;
            if (valid(board, word, i, j-1, k+1, visited)) return true;
            visited[i][j-1] = 0;
        }
        if (j+1<board[0].length && board[i][j+1] == word.charAt(k+1) && visited[i][j+1] != 1){
            visited[i][j+1] = 1;
            if (valid(board, word, i, j+1, k+1, visited)) return true;
            visited[i][j+1] = 0;
        }
        return false;
    }
}
