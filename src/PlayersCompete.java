import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PlayersCompete {
    public static void main(String[] args){
        int[] res = earliestAndLatest(11, 2, 4);
        System.out.println(res[0] +","+res[1]);
    }

    public static int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) list.add(i);
        return new int[]{min(list, 0, new ArrayList<>(), 0, firstPlayer, secondPlayer), max(list, 0, new ArrayList<>(), 0, firstPlayer, secondPlayer)};
    }

    private static int min(List<Integer> parent, int i, List<Integer> current, int j, int firstPlayer, int secondPlayer){
        if (parent.size() == 1) return 1000000000;
        if (i==(parent.size()+1)/2){
            return 1+min(current, 0, new ArrayList<>(), 0, firstPlayer, secondPlayer);
        }
        if (parent.get(i) == firstPlayer && parent.get(parent.size()-1-i) == secondPlayer) return 1;
        current.add(j, parent.get(i));
        int min = min(parent, i+1, current, j+1, firstPlayer, secondPlayer);
        current.set(j, parent.get(parent.size()-1-i));
        min = Math.min(min, min(parent, i+1, current, j, firstPlayer, secondPlayer));
        current.remove(j);
        return min;
    }

    private static int max(List<Integer> parent, int i, List<Integer> current, int j, int firstPlayer, int secondPlayer){
        if (parent.size() == 1) return -1000000000;
        if (i==(parent.size()+1)/2){
            return 1+max(current, 0, new ArrayList<>(), 0, firstPlayer, secondPlayer);
        }
        if (parent.get(i) == firstPlayer && parent.get(parent.size()-1-i) == secondPlayer) return 1;
        current.add(j, parent.get(i));
        int max = max(parent, i+1, current, j+1, firstPlayer, secondPlayer);
        current.set(j, parent.get(parent.size()-1-i));
        max = Math.max(max, max(parent, i+1, current, j, firstPlayer, secondPlayer));
        current.remove(j);
        return max;
    }
}