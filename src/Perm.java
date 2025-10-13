import java.util.Arrays;

class Perm {
    public static void main(String[] args){
        System.out.println(Arrays.toString(prevPermOpt1(new int[]{1, 1, 5})));
    }

    public static int[] prevPermOpt1(int[] arr) {
        for (int i=arr.length-1; i>=0; i--){
            int index = -1;
            for (int j=arr.length-1; j>i; j--){
                if (arr[j]<arr[i] && (index == -1 || arr[j]>=arr[index])) index = j;
            }
            if (index != -1){
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                return arr;
            }
        }
        return arr;
    }
}