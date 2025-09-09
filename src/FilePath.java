import java.util.*;

public class FilePath {
    public static void main(String[] args){
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

    public static int lengthLongestPath(String input) {
        Map<Integer, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        String[] path = input.split("\n");
        for (int i=0; i<path.length; i++){
            String str = path[i];
            int j=0;
            while (str.charAt(j) == 9){
                j++;
            }
            map.put(i, j);
            list.add(str.substring(j));
        }
        int max = 0;
        int current = 0;
        Stack<String> stack = new Stack<>();
        for (int i=0; i<list.size(); i++){
            if (map.get(i) <= stack.size()){
                while (map.get(i) < stack.size()){
                    current -= stack.peek().length();
                    stack.pop();
                };
                current += list.get(i).length();
                stack.push(list.get(i));
                for (char c: list.get(i).toCharArray()){
                    if (c == '.') max = Math.max(max, current+stack.size()-1);
                }
            }
        }
        return max;
    }

}
