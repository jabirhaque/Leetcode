import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordSearch {
    public static void main(String[] args){
        char[][] board = {{'A','B'},{'C','D'}};
        System.out.println(exist(board, "CDBA"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (recursion(board, ""+board[i][j], word, i, j, new HashSet<>())){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean recursion(char[][] board, String current, String word, int i, int j, Set<List<Integer>> route){
        if (route.contains(List.of(i, j))){
            return false;
        }
        Set<List<Integer>> newRoute = new HashSet<>(route);
        newRoute.add(List.of(i, j));
        if (current.length() == word.length()){
            return current.equals(word);
        }
        if (current.charAt(current.length()-1)!=word.charAt(current.length()-1)){
            return false;
        }
        if (i!=0){
            if (recursion(board, current+board[i-1][j], word, i-1, j, newRoute)){
                return true;
            }
        }
        if (i!=board.length-1){
            if (recursion(board, current+board[i+1][j], word, i+1, j, newRoute)){
                return true;
            }
        }
        if (j!=0){
            if (recursion(board, current+board[i][j-1], word, i, j-1, newRoute)){
                return true;
            }
        }
        if (j!=board[0].length-1){
            return recursion(board, current+board[i][j+1], word, i, j+1, newRoute);
        }
        return false;
    }
}