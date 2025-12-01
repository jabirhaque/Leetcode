import java.util.Stack;

class ABC {
    public static void main(String[] args){
        System.out.println(isValid("aabcbc"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (stack.size() < 2 || c != 'c') stack.push(c);
            else{
                char second = stack.pop();
                char first = stack.pop();
                if (first != 'a' || second != 'b'){
                    stack.push(first);
                    stack.push(second);
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}