import java.util.Stack;

class MinimumOperation {
    public int minOperations(int[] nums) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int n: nums){
            if (n == 0){
                stack.clear();
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > n) stack.pop();
            if (stack.isEmpty() || stack.peek() < n){
                count++;
                stack.push(n);
            }
        }
        return count;
    }
}