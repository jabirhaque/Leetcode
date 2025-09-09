import java.util.HashSet;
import java.util.Set;

class Express {
    public static void main(String[] args){
        System.out.println(numberOfWays(6, 1));
    }

    public static int numberOfWays(int n, int x) {
        Set<Integer> bases = new HashSet<>();
        for (int i=1; i<=n; i++){
            bases.add(i);
        }
        return recursion(n, x, bases);
    }

    private static int recursion(int n, int x, Set<Integer> bases){
        if (n == 0){
            return 1;
        }if (n<0){
            return 0;
        }
        int res = 0;
        Set<Integer> newBases = new HashSet<>(bases);
        for (int i: bases){
            newBases.remove(i);
            res+=recursion(n-(int)Math.pow(i, x), x, newBases);
            newBases.add(i);
        }
        return res;
    }
}