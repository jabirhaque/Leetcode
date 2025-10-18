import java.util.*;

class Cinema {
    public static void main(String[] args){
        System.out.println(maxNumberOfFamilies(3, new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}}));
    }

    public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] res: reservedSeats){
            if (!map.containsKey(res[0])){
                List<Integer> list = new ArrayList<>(List.of(0, 11));
                map.put(res[0], list);
            }
            int index = -(1+ Collections.binarySearch(map.get(res[0]), res[1]));
            map.get(res[0]).add(index, res[1]);
        }
        int count = 0;
        for (int i: map.keySet()){
            List<Integer> list = map.get(i);
            for (int j=0; j<list.size()-1; j++){
                if (list.get(j) < 2){
                    if (list.get(j+1) > 9) count+=2;
                    else if (list.get(j+1) > 5) count++;
                }
                else if (list.get(j) < 4 && list.get(j+1) > 7) count++;
                else if (list.get(j) < 6 && list.get(j+1) > 9) count++;
            }
        }
        count += (n-map.size())*2;
        return count;
    }
}