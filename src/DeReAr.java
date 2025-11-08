import java.util.Arrays;

class DeReAr {
    public static void main(String[] args){
        int[] arr = new int[10000];
        Arrays.fill(arr, 209);
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        for (int i=0; i<arr.length; i++){
            if (i == 0) arr[i] = 1;
            else arr[i] = Math.min(arr[i], arr[i-1]+1);
        }
        return arr[arr.length-1];
    }
}
