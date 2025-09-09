import java.util.*;

class DDouble {
    public static void main(String[] args) {
        System.out.println(canReorderDoubled(new int[]{-62,86,96,-18,43,-24,-76,13,-31,-26,-88,-13,96,-44,9,-20,-42,100,-44,-24,-36,28,-32,58,-72,20,48,-36,-45,14,24,-64,-90,-44,-16,86,-33,48,26,29,-84,10,46,50,-66,-8,-38,92,-19,43,48,-38,-22,18,-32,-48,-64,-10,-22,-48}));
    }

    public static boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: arr){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (int n: arr){
            if (map.get(n) == 0) continue;
            if (map.getOrDefault(2*n, 0) == 0 && (n%2!=0 || map.getOrDefault(n/2, 0) == 0)){
                return false;
            }
            if (n%2==0 && map.getOrDefault(n/2, 0) != 0){
                map.replace(n, map.get(n)-1);
                map.replace(n/2, map.get(n/2)-1);
            }else{
                map.replace(n, map.get(n)-1);
                map.replace(2*n, map.get(2*n)-1);
            }
        }
        return true;
    }
}