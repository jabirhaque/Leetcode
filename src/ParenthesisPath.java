import java.util.Stack;

class ParenthesisPath {
    public static void main(String[] args){
        System.out.println(hasValidPath(new char[][]{{'(',')',')','(',')',')',')'}}));
    }

    public static boolean hasValidPath(char[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid.length+grid[0].length+1];
        return dp(grid, 0, 0, new Stack<>(), dp);
    }

    private static boolean dp(char[][] grid, int i, int j, Stack<Character> stack, int[][][] dp){
        if (dp[i][j][stack.size()] == 1) return false;
        if (stack.isEmpty()){
            if (grid[i][j] == ')') return false;
            stack.push('(');
        }else{
            if (grid[i][j] == '(') stack.push('(');
            else stack.pop();
        }
        if (i == grid.length-1 && j == grid[0].length-1){
            boolean result = stack.isEmpty();
            if (grid[i][j] == '(') stack.pop();
            else stack.push('(');
            return result;
        }
        if (i+1 < grid.length && dp(grid, i+1, j, stack, dp)) return true;
        if (j+1 < grid[0].length && dp(grid, i, j+1, stack, dp)) return true;
        if (grid[i][j] == '(') stack.pop();
        else stack.push('(');
        dp[i][j][stack.size()] = 1;
        return false;
    }
}