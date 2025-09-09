import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SplitFactors {
    public static void main(String[] args){
        System.out.println(Arrays.toString(minDifference(100, 2)));
    }

    public static int[] minDifference(int n, int k) {
        List<List<Integer>> split = split(n, k);
        int smallest = Integer.MAX_VALUE;
        int i=0;
        for (int j=0; j<split.size(); j++){
            int s = Integer.MAX_VALUE;
            int b = 0;
            for (int a: split.get(j)){
                s = Math.min(s, a);
                b = Math.max(b, a);
            }
            if (b-s<smallest){
                smallest = b-s;
                i=j;
            }
        }
        int[] res = new int[k];
        for (int j=0; j<k; j++){
            res[j] = split.get(i).get(j);
        }
        return res;
    }

    private static List<List<Integer>> split(int n, int k){
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i=1; i<(int)(Math.sqrt(n)+1); i++){
            if (n%i == 0){
                if (k == 2){
                    pairs.add(List.of(i, n/i));
                }else{
                    List<List<Integer>> sub = split(n/i, k-1);
                    for (List<Integer> s: sub){
                        List<Integer> m = new ArrayList<>(s);
                        m.add(i);
                        pairs.add(m);
                    }
                }
            }
        }
        return pairs;
    }
}