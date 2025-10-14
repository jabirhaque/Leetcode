import java.util.*;

class Barcodes {
    public static void main(String[] args){
        System.out.println(Arrays.toString(rearrangeBarcodes(new int[]{2, 2, 2, 1, 5})));
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: barcodes) map.put(n, map.getOrDefault(n, 0)+1);
        List<List<Integer>> list = new ArrayList<>();
        for (int n: map.keySet()) list.add(new ArrayList<>(List.of(n, map.get(n))));
        Collections.sort(list, (a, b) -> a.get(1)-b.get(1));
        int[] res = new int[barcodes.length];
        for (int i=0; i<barcodes.length; i++){
            int prev = i==0?-1:res[i-1];
            int j = list.size()-1;
            if (list.get(j).get(0) == prev) j--;
            List<Integer> selected = list.get(j);
            list.remove(j);
            res[i] = selected.get(0);
            selected.set(1, selected.get(1)-1);
            int index = Collections.binarySearch(list, selected, Comparator.comparingInt(a -> a.get(1)));
            if (index<0) index = -(1+index);
            list.add(index, selected);
        }
        return res;
    }
}