import java.util.List;

class MaxDistance {
    public static void main(String[] args){
        System.out.println(maxDistance(List.of(List.of(1,5),List.of(3,4))));
    }

    public static int maxDistance(List<List<Integer>> arrays) {
        return Math.max(smallestFirst(arrays), biggestFirst(arrays));
    }

    public static int smallestFirst(List<List<Integer>> arrays) {
        int smallest = 0;
        for (int i=0; i<arrays.size(); i++){
            if (arrays.get(i).get(0) < arrays.get(smallest).get(0)) smallest = i;
        }
        int biggest=0;
        for (int i=0; i<arrays.size(); i++){
            if (arrays.get(i).get(arrays.get(i).size()-1) > arrays.get(biggest).get(arrays.get(biggest).size()-1) && i!=smallest) biggest = i;
        }
        return arrays.get(biggest).get(arrays.get(biggest).size()-1) - arrays.get(smallest).get(0);
    }

    public static int biggestFirst(List<List<Integer>> arrays) {
        int biggest=0;
        for (int i=0; i<arrays.size(); i++){
            if (arrays.get(i).get(arrays.get(i).size()-1) > arrays.get(biggest).get(arrays.get(biggest).size()-1)) biggest = i;
        }
        int smallest = 0;
        for (int i=0; i<arrays.size(); i++){
            if (arrays.get(i).get(0) < arrays.get(smallest).get(0) && i != biggest) smallest = i;
        }
        return arrays.get(biggest).get(arrays.get(biggest).size()-1) - arrays.get(smallest).get(0);
    }
}