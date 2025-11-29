import java.util.Arrays;
import java.util.Stack;

class SumMinimums {
    public static void main(String[] args){
        System.out.println(sumSubarrayMins(new int[]{71,55,82,55}));
    }

    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int[] right = new int[arr.length];
        Arrays.fill(right, arr.length);
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) right[stack.pop()] = i;
            stack.push(i);
        }
        int[] left = new int[arr.length];
        Arrays.fill(left, -1);
        stack.clear();
        for (int i = arr.length-1; i>=0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) left[stack.pop()] = i;
            stack.push(i);
        }
        long res = 0;
        for (int i=0; i<arr.length; i++) {
            res = (res + (long)arr[i] * (i-left[i]) * (right[i]-i)) % MOD;
        }
        return (int)res;
    }
}