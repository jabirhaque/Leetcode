import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calc {
    public static void main(String[] args){
        System.out.println(calculate("31+2222*2"));
        System.out.println(calculate("3+2*2"));
    }

    public static int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') sb.append(c);
        }
        String str = sb.toString();

        List<String> list = new ArrayList<>();
        int last = 0;
        for (int i=0; i<=str.length(); i++){
            if (i == str.length() || str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*'|| str.charAt(i) == '/'){
                list.add(str.substring(last, i));
                if (i<str.length()) list.add(str.substring(i, i+1));
                last = i+1;
            }
        }
        Stack<String> stack = new Stack<>();
        for (int i=0; i<list.size(); i++){
            if (list.get(i).equals("*")){
                stack.push(String.valueOf(Integer.valueOf(stack.pop()) * Integer.valueOf(list.get(i+1))));
                i++;
            }else if (list.get(i).equals("/")){
                stack.push(String.valueOf(Integer.valueOf(stack.pop()) / Integer.valueOf(list.get(i+1))));
                i++;
            }else{
                stack.push(list.get(i));
            }
        }
        list = new ArrayList<>(stack);
        Stack<Integer> newStack = new Stack<>();
        for (int i=0; i<list.size(); i++){
            if (list.get(i).equals("+")){
                newStack.push(newStack.pop()+Integer.valueOf(list.get(i+1)));
                i++;
            }else if (list.get(i).equals("-")){
                newStack.push(newStack.pop()-Integer.valueOf(list.get(i+1)));
                i++;
            }else{
                newStack.push(Integer.valueOf(list.get(i)));
            }
        }
        return newStack.pop();
    }
}
