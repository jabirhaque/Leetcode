import java.util.ArrayList;
import java.util.List;

public class AsciiDifference {
    public static void main(String[] args){
        String s = "abcd";
        String t = "cdef";
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i=0; i<s.length(); i++){
            int abs = Math.abs(s.charAt(i) - t.charAt(i));
            list.add(abs);
            sum += abs;
        }
        System.out.println(list);
        System.out.println(sum);
    }
}
