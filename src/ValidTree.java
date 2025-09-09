import java.util.Stack;

class ValidTree {
    public static void main(String[] args){
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
    }
    public static boolean isValidSerialization(String preorder) {
        if (preorder.length() == 1){
            return preorder.charAt(0) == '#';
        }
        String[] list = preorder.split(",");
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<list.length; i++){
            String c = list[i];
            if (c.equals("#")){
                if (stack.empty()){
                    return false;
                }
                while (!stack.empty() && stack.peek() == 1){
                    stack.pop();
                }
                if (!stack.empty()){
                    stack.pop();
                    stack.push(1);
                }
            }else{
                if (stack.empty() && i!=0){
                    return false;
                }
                stack.push(0);
            }
        }
        return stack.empty();
    }
}