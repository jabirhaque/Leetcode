import java.util.HashSet;
import java.util.List;
import java.util.Set;

class MatchSticks {
    public static void main(String[] args){
        System.out.println(makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }

    public static boolean makesquare(int[] matchsticks) {
        return valid(matchsticks, new boolean[matchsticks.length], 0, 0, 0, -1, new HashSet<>(List.of(0)));
    }

    private static boolean valid(int[] matchsticks, boolean[] used, int i, int side, int current, int target, Set<Integer> dp){
        if (side == 0){
            if (i == matchsticks.length){
                boolean res = !dp.contains(current) && valid(matchsticks, used, 0, side+1, 0, current, dp);
                if (res) return res;
                dp.add(current);
                return res;
            }
            if (valid(matchsticks, used, i+1, side, current, target, dp)) return true;
            if (!used[i]){
                used[i] = true;
                if (valid(matchsticks, used, i+1, side, current+matchsticks[i], target, dp)) return true;
                used[i] = false;
            }
            return false;
        }
        if (current>target) return false;
        if (side == 3){
            for (int j=0; j<used.length; j++) if (!used[j]) target -= matchsticks[j];
            return target == 0;
        }
        if (i == matchsticks.length) return current == target && valid(matchsticks, used, 0, side+1, 0, target, dp);
        if (valid(matchsticks, used, i+1, side, current, target, dp)) return true;
        if (!used[i]){
            used[i] = true;
            if (valid(matchsticks, used, i+1, side, current+matchsticks[i], target, dp)) return true;
            used[i] = false;
        }
        return false;
    }
}