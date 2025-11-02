import java.util.*;

class MinRem {
    public static void main(String[] args){
        System.out.println(minimumRemoval(new int[]{60}));
    }

    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long[] prefix = new long[beans.length];
        prefix[0] = beans[0];
        for (int i=1; i<beans.length; i++){
            prefix[i] = beans[i] + prefix[i-1];
        }
        long min = Long.MAX_VALUE;
        for (int i=0; i<beans.length-1; i++){
            min = Math.min(min, prefix[prefix.length-1]-((long)beans[i+1]*(long)(beans.length-1-i)));
        }
        return min;
    }
}