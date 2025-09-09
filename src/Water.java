import java.util.HashSet;
import java.util.Set;

class Water {
    public static void main(String[] args){
        System.out.println(canMeasureWater(3, 5, 4));
    }

    public static boolean canMeasureWater(int x, int y, int target) {
        return recursion(x, y, target, 0, 0, new HashSet<>());
    }

    private static boolean recursion(int x, int y, int target, int currx, int curry, Set<String> set){
        String key = currx+","+curry;
        if (set.contains(key)){
            return false;
        }
        set.add(key);
        if (currx == target || curry == target){
            return true;
        }
        if (recursion(x, y, target, x, curry, set)){
            return true;
        }
        if (recursion(x, y, target, currx, y, set)){
            return true;
        }
        if (recursion(x, y, target, 0, curry, set)){
            return true;
        }
        if (recursion(x, y, target, currx, 0, set)){
            return true;
        }
        if (recursion(x, y, target, Math.min(x, currx+curry), curry-(Math.min(x, currx+curry)-currx), set)){
            return true;
        }
        if (recursion(x, y, target, currx-(Math.min(y, currx+curry)-curry), Math.min(y, currx+curry), set)){
            return true;
        }
        return false;
    }
}