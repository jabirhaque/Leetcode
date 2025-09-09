import java.util.*;

class Calculator {
    public static void main(String[] args){
        System.out.println(calculate(" 3/2 "));
    }

    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Set<Character> set = new HashSet<>(List.of('+', '-', '*', '/'));
        List<String> list = new ArrayList<>();
        int i=0;
        while (i<s.length()){
            if (set.contains(s.charAt(i))){
                list.add(""+s.charAt(i));
                i++;
            }else{
                int j=i;
                while (j<s.length() && !set.contains(s.charAt(j))){
                    j++;
                }
                list.add(s.substring(i, j));
                i=j;
            }
        }
        Stack<String> stack = new Stack<>();
        i=0;
        while (i<list.size()){
            if (list.get(i).equals("*")){
                int result = Integer.valueOf(stack.pop())*Integer.valueOf(list.get(i+1));
                stack.push(String.valueOf(result));
                i++;
            }else if (list.get(i).equals("/")){
                int result = Integer.valueOf(stack.pop())/Integer.valueOf(list.get(i+1));
                stack.push(String.valueOf(result));
                i++;
            }else{
                stack.push(list.get(i));
            }
            i++;
        }
        List<String> newList = new ArrayList<>();
        while (!stack.empty()){
            newList.add(0, stack.pop());
        }
        i=0;
        while (i<newList.size()){
            if (newList.get(i).equals("+")){
                int result = Integer.valueOf(stack.pop())+Integer.valueOf(newList.get(i+1));
                stack.push(String.valueOf(result));
                i++;
            }else if (newList.get(i).equals("-")){
                int result = Integer.valueOf(stack.pop())-Integer.valueOf(newList.get(i+1));
                stack.push(String.valueOf(result));
                i++;
            }else{
                stack.push(newList.get(i));
            }
            i++;
        }
        return Integer.valueOf(stack.pop());
    }
}