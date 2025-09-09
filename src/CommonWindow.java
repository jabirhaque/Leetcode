import java.util.HashMap;
import java.util.Map;

public class CommonWindow {
    public static void main(String[] args){
        System.out.println(solution(new int[]{1,2,3,2,2,1,4,5}, new int[]{2,1,2}));
    }

    static int solution(int[] a, int[] b){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: b){
            if (map.containsKey(i)){
                map.replace(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }
        Map<Integer, Integer> current = new HashMap<>();
        if (map.containsKey(a[0])){
            current.put(a[0], 1);
        }
        int l=0;
        int r=0;
        int min = Integer.MAX_VALUE;
        while (r<a.length){
            if (met(map, current)){
                min = Math.min(min, r-l+1);
                if (current.containsKey(a[l]) && current.get(a[l]) == 1){
                    current.remove(a[l]);
                }else if(current.containsKey(a[l])){
                    current.replace(a[l], current.get(a[l])-1);
                }
                l++;
            }else{
                r++;
                if (r<a.length && current.containsKey(a[r])){
                    current.replace(a[r], current.get(a[r])+1);
                }else if (r<a.length){
                    current.put(a[r], 1);
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }

    private static boolean met(Map<Integer, Integer> map, Map<Integer, Integer> current){
        for (int c: map.keySet()){
            if (!current.containsKey(c) || current.get(c)<map.get(c)){
                return false;
            }
        }
        return true;
    }
}
