import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Confluent {

    /*
     * Complete the 'getMinimumCost' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. STRING_ARRAY featureAvailability
     */

    public static void main(String[] args) {
        List<Integer> cost = List.of(3, 6, 9, 1);
        List<String> featureAvailability = List.of("10", "01", "01", "10");
        System.out.println(getMinimumCost(cost, featureAvailability));
    }

    public static List<Integer> getMinimumCost(List<Integer> cost, List<String> featureAvailability) {
        PriorityQueue<Integer> bothIndex = new PriorityQueue<>((a, b) -> cost.get(a) - cost.get(b));
        PriorityQueue<Integer> firstIndex = new PriorityQueue<>((a, b) -> cost.get(a) - cost.get(b));
        PriorityQueue<Integer> secondIndex = new PriorityQueue<>((a, b) -> cost.get(a) - cost.get(b));
        for (int i=0; i<cost.size(); i++){
            if (featureAvailability.get(i).equals("11")) bothIndex.add(i);
            if (featureAvailability.get(i).equals("10")) firstIndex.add(i);
            if (featureAvailability.get(i).equals("01")) secondIndex.add(i);
        }
        List<Integer> result = new ArrayList<>();

        boolean flag = false;

        int last = 0;
        for (int i=0; i<cost.size(); i++){
            if (flag) result.add(-1);

            if (bothIndex.isEmpty() && (firstIndex.isEmpty() || secondIndex.isEmpty())) {
                result.add(-1);
                flag = true;
            }
            else if (bothIndex.isEmpty()){
                result.add(last + cost.get(firstIndex.poll()) + cost.get(secondIndex.poll()));
            }
            else if (firstIndex.isEmpty() || secondIndex.isEmpty()){
                result.add(last + cost.get(bothIndex.poll()));
            }
            else{
                int both = cost.get(bothIndex.peek());
                int firstAndSecond = cost.get(firstIndex.peek()) + cost.get(secondIndex.peek());
                if (both<firstAndSecond){
                    result.add(last + cost.get(bothIndex.poll()));
                }else{
                    result.add(last + cost.get(firstIndex.poll()) + cost.get(secondIndex.poll()));
                }
            }
            last = result.get(i);
        }
        return result;
    }

}