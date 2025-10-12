import java.util.ArrayList;
import java.util.List;

public class Pancake {

    public static void main(String[] args){
        System.out.println(pancakeSort(new int[]{5,1,3,4,2}));
    }

    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<=arr.length; i++){
            for (int j=0; j< arr.length; j++){
                if (arr[j] == i){
                    result.add(j+1);
                    pancake(arr, j+1);
                    result.add(arr.length+1-i);
                    pancake(arr, arr.length+1-i);
                    break;
                }
            }
        }
        result.add(arr.length);
        return result;
    }

    private static int[] pancake(int[] arr, int i){
        for (int j=0; j<i/2; j++){
            int temp = arr[j];
            arr[j] = arr[i-j-1];
            arr[i-j-1] = temp;
        }
        return arr;
    }
}
