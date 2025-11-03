import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DoubleArray {
    public static void main(String[] args){
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1, 1, 2, 4})));
    }

    public static int[] findOriginalArray(int[] changed) {
        if (changed.length%2 == 1) return new int[]{};
        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: changed) map.put(n, map.getOrDefault(n, 0)+1);
        Map<Integer, Integer> skip = new HashMap<>();
        int i=0;
        int[] res = new int[changed.length/2];
        int j=0;
        while (i<changed.length && j<res.length){
            if (skip.containsKey(changed[i])){
                if (skip.get(changed[i]) > 1) skip.put(changed[i], skip.get(changed[i])-1);
                else skip.remove(changed[i]);
            }else{
                if (map.get(changed[i]) > 1) map.put(changed[i], map.get(changed[i])-1);
                else map.remove(changed[i]);
                if (!map.containsKey(changed[i]*2)) return new int[]{};
                if (map.get(changed[i]*2) > 1) map.put(changed[i]*2, map.get(changed[i]*2)-1);
                else map.remove(changed[i]*2);
                skip.put(changed[i]*2, skip.getOrDefault(changed[i]*2, 0)+1);
                res[j] = changed[i];
                j++;
            }
            i++;
        }
        if (j < res.length) return new int[]{};
        return res;
    }
}