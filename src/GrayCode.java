import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GrayCode {
    public static void main(String[] args){
        System.out.println(grayCode(3));
    }

    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        return recursion(list, set, n);
    }

    private static List<Integer> recursion(List<Integer> current, Set<Integer> set, int n){
        if (current.size() == (int)Math.pow(2, n)){
            if (valid(current.get(0), current.get(current.size()-1))){
                return current;
            }
            return new ArrayList<>();
        }
        for (int i=0; i<(int)Math.pow(2, n); i++){
            int last = current.getLast();
            if (!set.contains(i) && valid(last, i)){
                // List<Integer> newCurrent = new ArrayList<>();
                // newCurrent.addAll(current);
                // newCurrent.add(i);
                current.add(i);
                // Set<Integer> newSet = new HashSet<>();
                // newSet.addAll(set);
                // newSet.add(i);
                set.add(i);
                List<Integer> result = recursion(current, set, n);
                if (result.size()!=0){
                    return result;
                }
                current.remove(current.size()-1);
                set.remove(i);
            }
        }
        return new ArrayList<>();
    }

    private static boolean valid(int a, int b){
        int n = a^b;
        int max = (int)(Math.log(n) / Math.log(2));
        for (int i=0; i<=max; i++){
            if ((int)Math.pow(2, i) == n){
                return true;
            }
        }
        return false;
    }
}