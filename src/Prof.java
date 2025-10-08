import java.util.*;

class Prof {
    public static void main(String[] args){
        System.out.println(maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82}));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<difficulty.length; i++){
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
        }
        List<List<Integer>> list = new ArrayList<>();
        for (Integer i: map.keySet()) list.add(new ArrayList<>(List.of(i, map.get(i))));
        Collections.sort(list, (a, b) -> a.get(0)-b.get(0));
        for (int i=1; i<list.size(); i++) list.get(i).set(1, Math.max(list.get(i-1).get(1), list.get(i).get(1)));
        List<Integer> search = new ArrayList<>(map.keySet());
        Collections.sort(search);
        int prof = 0;
        for (int w: worker){
            int index = Collections.binarySearch(search, w);
            if (index<0) index = -(1+index)-1;
            if (index>=0) prof+=list.get(index).get(1);
        }
        return prof;
    }
}