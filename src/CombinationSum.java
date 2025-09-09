import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CombinationSum {

    public static Map<Map<Integer, Integer>, Integer> result = new HashMap<>();

    public static void main(String[] args){
        recurse(new int[] {2,7}, 7, new HashMap<>());
        System.out.println(result);
    }

    private static void recurse(int[] candidates, int target, Map<Integer, Integer> current){
        if (target==0 && !result.containsKey(current)){
            result.put(current, 1);
        }
        if (target<=0){
            return;
        }
        for (int i=0; i<candidates.length; i++){
            int c = candidates[i];
            if (current.containsKey(c)){
                current.replace(c, current.get(c)+1);
                recurse(candidates, target-c, current);
                current.replace(c, current.get(c)-1);
            }else{
                current.put(c, 1);
                recurse(candidates, target-c, current);
                current.remove(c);
            }
        }
    }
}