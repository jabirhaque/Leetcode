import java.util.Stack;

class RemoveK {
    public static void main(String[] args){
        System.out.println(removeKdigits("33526221184202197273", 19));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c: num.toCharArray()){
            while (!stack.isEmpty() && stack.peek() > c && k>0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        String result = "";
        while (!stack.isEmpty()) result = stack.pop() + result;
        return result.substring(0, result.length()-k);
    }
}