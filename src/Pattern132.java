import java.util.Stack;

class Pattern132 {
    public static void main(String[] args){
        System.out.println(find132pattern(new int[]{1,0,1,-4,-3}));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> increasing = new Stack<>();
        Stack<Integer> decreasing = new Stack<>();
        for (int n:nums){
            if (!decreasing.isEmpty() && !increasing.isEmpty() &&  n>decreasing.peek() && n<increasing.peek()) return true;
            if (increasing.isEmpty() || n>increasing.peek()) increasing.push(n);
            if (decreasing.isEmpty() || n<decreasing.peek()) decreasing.push(n);
        }
        return false;
    }
}