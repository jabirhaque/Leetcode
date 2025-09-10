import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextGreatestElement {
    public static void main(String[] args){
        System.out.println(nextGreaterElement(12));
    }

    public static int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char c: digits) list.add(c-'0');
        List<Integer> permutations = permutations(new ArrayList<>(), new ArrayList<>(), list);
        Collections.sort(permutations);
        for (int i=0; i<permutations.size(); i++){
            if (permutations.get(i) == n){
                if (i == permutations.size()-1) return -1;
                else return permutations.get(i+1);
            }
        }
        return -1;
    }

    private static List<Integer> permutations(List<Integer> result, List<Integer> current, List<Integer> digits){
        if (digits.size() == 0){
            int num = 0;
            for (int i=0; i<current.size(); i++){
                num += (int)Math.pow(10, current.size()-i-1)*current.get(i);
            }
            result.add(num);
            return result;
        }
        List<Integer> copy = new ArrayList<>(digits);
        for (int i=0; i<digits.size(); i++){
            current.add(digits.get(i));
            copy.remove(i);
            permutations(result, current, copy);
            copy.add(i, digits.get(i));
            current.remove(current.size()-1);
        }
        return result;
    }
}
