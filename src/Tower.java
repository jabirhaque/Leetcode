import java.util.Stack;

class Tower {
    public static void main(String[] args){
        System.out.println(maximumSumOfHeights(new int[]{6,5,3,9,2,7}));
    }

    public static long maximumSumOfHeights(int[] heights) {
        long min = Long.MAX_VALUE;
        long sum = 0;
        for (int i=0; i<heights.length; i++){
            sum += heights[i];
            min = Math.min(min, evaluatePeak(heights, i));
        }
        return sum-min;
    }

    private static long evaluatePeak(int[] heights, int p){
        int[] dupe = new int[heights.length];
        for (int i=0; i<heights.length; i++) dupe[i] = heights[i];
        long count = 0;
        for (int j=p-1; j>=0; j--){
            count += dupe[j] - Math.min(dupe[j], dupe[j+1]);
            dupe[j] = Math.min(dupe[j], dupe[j+1]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i=p; i<heights.length; i++){
            if (!stack.isEmpty() && stack.peek()<heights[i]){
                count += heights[i]-stack.peek();
                stack.push(stack.peek());
            }else{
                stack.push(heights[i]);
            }
        }
        return count;
    }
}