import java.util.*;

class WordNode{
    char c;
    Map<Character, WordNode> neighbours;
    String word;
    WordNode(char c){
        this.c = c;
        this.neighbours = new HashMap<>();
        this.word = null;
    }
}

class WordSearchII {
    public static void main(String[] args){
        System.out.println(findWords(new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        }, new String[]{"oath","pea","eat","rain"}));
    }
    public static List<String> findWords(char[][] board, String[] words) {
        WordNode head = new WordNode('.');
        for (String str: words){
            WordNode current = head;
            for (char c: str.toCharArray()){
                if (!current.neighbours.containsKey(c)) current.neighbours.put(c, new WordNode(c));
                current = current.neighbours.get(c);
            }
            current.word = str;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<>();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                backtrack(board, i, j, head, result, visited);
            }
        }
        return new ArrayList<>(result);
    }

    private static Set<String> backtrack(char[][] board, int i, int j, WordNode node, Set<String> result, boolean[][] visited){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length) return result;
        if (!node.neighbours.containsKey(board[i][j])) return result;
        if (visited[i][j]) return result;
        visited[i][j] = true;
        if (node.neighbours.get(board[i][j]).word != null) result.add(node.neighbours.get(board[i][j]).word);
        result = backtrack(board, i-1, j, node.neighbours.get(board[i][j]), result, visited);
        result = backtrack(board, i+1, j, node.neighbours.get(board[i][j]), result, visited);
        result = backtrack(board, i, j-1, node.neighbours.get(board[i][j]), result, visited);
        result = backtrack(board, i, j+1, node.neighbours.get(board[i][j]), result, visited);
        visited[i][j] = false;
        return result;
    }
}