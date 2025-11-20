import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GrayCode {
    public static void main(String[] args){
        System.out.println(valid(13, 5)); //01101
    }

    public static List<Integer> grayCode(int n) {
        return List.of();
    }

    private static Set<Integer> valid(int number, int n){
        int remaining = number;
        List<Boolean> bit = new ArrayList<>();
        for (int i=n-1; i>=0; i--){
            if (remaining>=Math.pow(2, i)){
                bit.add(0, true);
                remaining -= Math.pow(2, i);
            }else bit.add(0, false);
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<n; i++){
            if (bit.get(i)) set.add(number-(int)Math.pow(2, i));
            else set.add(number+(int)Math.pow(2, i));
        }
        return set;
    }
}