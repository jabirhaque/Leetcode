import java.util.Stack;

class ValidStack {
    public static void main(String[] args){
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int j=0;
        while (i<pushed.length || j<pushed.length){
            if (!stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }else{
                if (i==pushed.length) return false;
                stack.push(pushed[i]);
                i++;
            }
        }
        return true;
    }
}