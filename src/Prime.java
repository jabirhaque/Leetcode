import java.util.ArrayList;
import java.util.List;

class Prime {
    public static void main(String[] args){
        System.out.println(nthSuperUglyNumber(15, new int[]{3,5,7,11,19,23,29,41,43,47}));
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] used = new int[primes.length];
        for (int i=0; i<used.length; i++){
            used[i]=1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size()<n){
            int min = Integer.MAX_VALUE;
            int index = 0;
            int i=0;
            while (i<used.length && used[i] != 1){
                if (used[i]*primes[0]<min){
                    min = used[i]*primes[0];
                    index = i;
                }
                i++;
            }
            if (i==used.length || min<primes[i]){
                list.add(min);
                used[index] = min;
            }else{
                list.add(primes[i]);
                used[i] = primes[i];
            }
        }
        return list.get(n-1);
    }
}