import java.util.HashMap;
import java.util.Map;

public class Bloomberg {
    public static void main(String[] args){
        method(new String[][]{{"2", "something"}, {"5", "something else"}, {"1", "some thing"}, {"4", "thing of some"}, {"3", "some of thing"}});
    }

    public static void method(String[][] list){
        Map<String, String> map = new HashMap<>();
        map.put(list[0][0], list[0][1]);
        int count = 1;
        int index = 1;
        while (count <= list.length){
            if (map.containsKey(String.valueOf(count))){
                System.out.println(map.get(String.valueOf(count)));
                count++;
            }else{
                map.put(list[index][0], list[index][1]);
                index++;
            }
        }
    }
}
