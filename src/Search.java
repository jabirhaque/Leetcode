import java.util.*;

class Node{
    char character;
    List<Character> characters;
    Map<Character, Node> map;
    String word;
    Node(char character){
        this.character = character;
        this.characters = new ArrayList<>();
        this.map = new HashMap<>();
        this.word = null;
    }
}

class Search {
    public static void main(String[] args){
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node('.');
        for (String product: products){
            Node current = root;
            for (int i=0; i<product.length(); i++){
                if (current.map.containsKey(product.charAt(i))){
                    current = current.map.get(product.charAt(i));
                }else{
                    int index = -(1+ Collections.binarySearch(current.characters, product.charAt(i)));
                    Node node = new Node(product.charAt(i));
                    current.characters.add(index, product.charAt(i));
                    current.map.put(product.charAt(i), node);
                    current = node;
                }
                if (i == product.length()-1) current.word = product;
            }
        }
        List<List<String>> result = new ArrayList<>();
        Node current = root;
        for (int i=0; i<searchWord.length(); i++){
            if (current.map.containsKey(searchWord.charAt(i))){
                current = current.map.get(searchWord.charAt(i));
            }else{
                int index = -(1+Collections.binarySearch(current.characters, searchWord.charAt(i)));
                Node node = new Node(searchWord.charAt(i));
                current.characters.add(index, searchWord.charAt(i));
                current.map.put(searchWord.charAt(i), node);
                current = node;
            }
            result.add(dfs(current, new ArrayList<>()));
        }
        return result;
    }

    private static List<String> dfs(Node node, List<String> current){
        if (current.size() == 3) return current;
        if (node.word != null) current.add(node.word);
        for (char c: node.characters){
            if (current.size() == 3) return current;
            dfs(node.map.get(c), current);
        }
        return current;
    }
}