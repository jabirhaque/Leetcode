import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CombinationSumIII {
    public static void main(String[] args){
        System.out.println(combinationSum3(4, 24));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        return recursion(k, n, 1, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> recursion(int k, int n, int i, List<Integer> current, List<List<Integer>> result){
        String key = n+","+i;
        if (current.size() == k){
            if (n == 0){
                result.add(current);
            }
            return result;
        }
        if (i == 10 || n<0){
            return result;
        }
        for (int j=i; j<10; j++){
            List<Integer> newCurrent = new ArrayList<>(current);
            newCurrent.add(j);
            result = recursion(k, n-j, j+1, newCurrent, result);
        }
        return result;
    }
}