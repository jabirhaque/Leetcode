import java.util.Stack;

class KDigits {
    public static void main(String[] args){
        System.out.println(removeKdigits("33526221184202197273", 19));
    }

    public static String removeKdigits(String num, int k) {
        if (k>=num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i=num.length()-1; i>=0; i--){
            stack.push(num.charAt(i));
        }
        char current = stack.pop();
        boolean flag = false;
        String result = "";
        while (!stack.empty() && k != 0){
            char compare = stack.pop();
            if (current<compare){
                if (!flag){
                    result = result + current;
                    flag = true;
                }
                k--;
            }else if (current>compare){
                result = result + compare;
                flag = true;
                current = compare;
                k--;
            }else{
                if (flag){

                }else{
                    result = result + current;
                }
                result = result + compare;
                current = compare;
                flag = true;
            }
        }
        while (!stack.empty()){
            result = result + stack.pop();
        }
        if (k!=0){
            return removeKdigitsRemoveDuplicate(String.valueOf(Integer.valueOf(result)), k);
        }
        return String.valueOf(Integer.valueOf(result));
    }

    public static String removeKdigitsRemoveDuplicate(String num, int k) {
        if (k>=num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i=num.length()-1; i>=0; i--){
            stack.push(num.charAt(i));
        }
        char current = stack.pop();
        boolean flag = false;
        String result = "";
        while (!stack.empty() && k != 0){
            char compare = stack.pop();
            if (current<compare){
                if (!flag){
                    result = result + current;
                    flag = true;
                }
                k--;
            }else if (current>compare){
                result = result + compare;
                flag = true;
                current = compare;
                k--;
            }else{
                if (!flag){
                    result = result + compare;
                }
                current = compare;
                flag = true;
                k--;
            }
        }
        while (!stack.empty()){
            result = result + stack.pop();
        }
        return String.valueOf(Integer.valueOf(result));
    }
}