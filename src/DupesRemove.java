import java.util.ArrayList;
import java.util.List;

public class DupesRemove {
    public static void main(String[] args){
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String s) {
        List<Character> list = new ArrayList<>();
        for (char c: s.toCharArray()) list.add(c);
        int i=0;
        while (i<list.size()){
            if (i<list.size()-1 && list.get(i) == list.get(i+1)){
                list.remove(i);
                list.remove(i);
                i--;
                if (i<0) i=0;
            }else{
                i++;
            }
        }
        String res = "";
        for (char c: list){
            res+=c;
        }
        return res;
    }
}
