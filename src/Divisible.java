import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Divisible {
    public static void main(String[] args){
        System.out.println(largestDivisibleSubset(new int[]{1,2,3}));
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int n: nums){
            list.add(n);
        }
        return recursion(list, new ArrayList<>(), new ArrayList<>());
    }

    private static List<Integer> recursion(List<Integer> remaining, List<Integer> current, List<Integer> biggest){
        while (remaining.size()>0){
            int first = remaining.get(0);
            remaining.remove(0);
            List<Integer> newCurrent = new ArrayList<>(current);
            biggest = recursion(remaining, newCurrent, biggest);
            if (newCurrent.size() == 0 || first%newCurrent.get(newCurrent.size()-1)==0){
                newCurrent.add(first);
                biggest = recursion(remaining, newCurrent, biggest);
            }
        }
        if (current.size()>biggest.size()){
            return current;
        }
        return biggest;
    }
}