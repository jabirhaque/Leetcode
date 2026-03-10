import java.util.ArrayList;
import java.util.List;

class AddParen {
    public static void main(String[] args){
        AddParen a = new AddParen();
        a.diffWaysToCompute("2-1-1");
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>[][] dp = new List[expression.length()][expression.length()];
        return backtrack(expression, 0, expression.length()-1, dp);
    }

    private List<Integer> backtrack(String expression, int i, int j, List<Integer>[][] dp){
        if (dp[i][j] != null) return dp[i][j];
        List<Integer> list = new ArrayList<>();
        for (int k=i; k<=j; k++){
            if (expression.charAt(k) == '+' || expression.charAt(k) == '-' || expression.charAt(k) == '*'){
                List<Integer> first = backtrack(expression, i, k-1, dp);
                List<Integer> second = backtrack(expression, k+1, j, dp);
                for (int n: first){
                    for (int m: second){
                        int res = 0;
                        if (expression.charAt(k) == '+') res = n+m;
                        if (expression.charAt(k) == '-') res = n-m;
                        if (expression.charAt(k) == '*') res = n*m;
                        list.add(res);
                    }
                }
            }
        }
        dp[i][j] = list.isEmpty() ? List.of(Integer.valueOf(expression.substring(i, j+1))) : list;
        return dp[i][j];
    }
}