import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HalfMinRem {
    public static void main(String[] args){
        System.out.println(halveArray(new int[]{5,19,8,1}));
    }

    public static int halveArray(int[] nums) {
        List<Double> list = new ArrayList<>();
        double sum = 0;
        for (double n: nums){
            list.add(n);
            sum += n;
        }
        Collections.sort(list);
        Double target = sum/2;
        int count = 0;
        while (sum>target){
            Double largest = list.get(list.size()-1);
            sum -= largest/2;
            list.remove(list.size()-1);
            int index = Collections.binarySearch(list, largest/2);
            if (index<0) index = -(1+index);
            list.add(index, largest/2);
            count++;
        }
        return count;
    }
}