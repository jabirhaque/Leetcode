import java.util.*;

class WordBreakRedoNode{
    char val;
    Map<Character, WordBreakRedoNode> neighbours;
    String word;
    WordBreakRedoNode(char val){
        this.val = val;
        this.neighbours = new HashMap<>();
        this.word = null;
    }
}

class WordBreakRedo {
    public static void main(String[] args){
        System.out.println(wordBreak("leetcode", List.of("leet","code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        WordBreakRedoNode root = new WordBreakRedoNode('.');
        for (String word: wordDict){
            WordBreakRedoNode current = root;
            for (char c: word.toCharArray()){
                if (!current.neighbours.containsKey(c)){
                    current.neighbours.put(c, new WordBreakRedoNode(c));
                }
                current = current.neighbours.get(c);
            }
            current.word = word;
        }
        return valid(s, 0, root, new HashSet<>());
    }

    private static boolean valid(String s, int i, WordBreakRedoNode root, Set<Integer> set){
        WordBreakRedoNode current = root;
        int j = 0;
        while (i+j<s.length()){
            if (current.neighbours.containsKey(s.charAt(i+j))) current = current.neighbours.get(s.charAt(i+j));
            else{
                set.add(i);
                return false;
            }
            j++;
            if (current.word != null && valid(s, i+j, root, set)) return true;
        }
        if (i+j == s.length() && current.word != null) return true;
        set.add(i);
        return false;
    }
}