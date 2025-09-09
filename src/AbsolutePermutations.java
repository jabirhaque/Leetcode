import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbsolutePermutations {
    public static void main(String[] args){
        System.out.println(absolutePermutation(4, 2));
    }

    public static List<Integer> absolutePermutation(int n, int k) {
        return recursion(n, k, new ArrayList<>(), new HashSet<>());
    }

    private static List<Integer> recursion(int n, int k, List<Integer> current, Set<Integer> used){
        if (current.size() == n){
            return current;
        }
        int lower = current.size()+1-k;
        int upper = current.size()+1+k;
        if (!used.contains(lower) && lower>0 && lower<=n){
            current.add(lower);
            used.add(lower);
            List<Integer> result = recursion(n, k, current, used);
            if (result.get(0) != -1){
                return result;
            }
            current.remove(current.size()-1);
            used.remove(lower);
        }
        if (!used.contains(upper) && upper>0 && upper<=n){
            current.add(upper);
            used.add(upper);
            List<Integer> result = recursion(n, k, current, used);
            if (result.get(0) != -1){
                return result;
            }
            current.remove(current.size()-1);
            used.remove(upper);
        }
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        return list;
    }
}
