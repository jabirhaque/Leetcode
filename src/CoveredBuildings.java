import java.util.*;

class CoveredBuildings {
    public static void main(String[] args){
        System.out.println(countCoveredBuildings(3, new int[][]{
                {1, 2},
                {2, 2},
                {3, 2},
                {2, 1},
                {2, 3}
        }));
    }

    public static int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, List<Integer>> x = new HashMap<>(); //y coordinates of each x
        Map<Integer, List<Integer>> y = new HashMap<>(); //x coordinates of each y
        for (int[] building: buildings){
            List<Integer> yList = x.getOrDefault(building[0], new ArrayList<>());
            x.put(building[0], yList);
            List<Integer> xList = y.getOrDefault(building[1], new ArrayList<>());
            y.put(building[1], xList);
            yList.add(building[1]);
            xList.add(building[0]);
        }
        for (int i: x.keySet()) Collections.sort(x.get(i));
        for (int i: y.keySet()) Collections.sort(y.get(i));
        int count = 0;
        for (int[] building: buildings){
            List<Integer> yList = x.get(building[0]);
            List<Integer> xList = y.get(building[1]);
            int xIndex = Collections.binarySearch(xList, building[0]);
            int yIndex = Collections.binarySearch(yList, building[1]);
            if (xIndex>0 && xIndex<xList.size()-1 && yIndex>0 && yIndex<yList.size()-1) count++;
        }
        return count;
    }
}