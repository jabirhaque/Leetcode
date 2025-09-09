import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ClumsyFactorial {
    public static void main(String[] args){
        clumsy(5);
    }

    public static int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) stack.push(i);
        while (stack.size()>1){
            int multiply = stack.pop()*stack.pop();
            stack.push(multiply);
            if (stack.size()>1){
                int divide = stack.pop()/stack.pop();
                stack.push(divide);
            }
            queue.add(stack.pop());
            if (!stack.isEmpty()) queue.add(stack.pop());
        }
        if (stack.size() == 1) queue.add(stack.pop());
        int res = queue.remove();
        int i = 1;
        for (int j: queue){
            res += j*i;
            i = i*-1;
        }
        return res;
    }
}