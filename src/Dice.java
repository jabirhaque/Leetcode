import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

class Dice {
    public static void main(String[] args){
        System.out.println(dieSimulator(30, new int[]{2,3,1,2,1,2}));
    }

    public static int dieSimulator(int n, int[] rollMax) {
        int[] current = new int[6];
        for (int i = 0; i < 6; i++) {
            current[i] = rollMax[i];
        }
        BigInteger res = recursion(n, current, rollMax, new HashMap<>());
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    private static BigInteger recursion(int n, int[] current, int[] rollMax, Map<String, BigInteger> map) {
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            keyBuilder.append(current[i]).append(',');
        }
        keyBuilder.append(n);
        String key = keyBuilder.toString();

        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (n == 0) {
            return BigInteger.ONE;
        }

        BigInteger total = BigInteger.ZERO;
        int[] state = new int[6];
        System.arraycopy(current, 0, state, 0, 6);

        for (int i = 0; i < 6; i++) {
            if (current[i] > 0) {
                for (int j = 0; j < 6; j++) {
                    if (j == i) {
                        current[j]--;
                    } else {
                        current[j] = rollMax[j];
                    }
                }
                total = total.add(recursion(n - 1, current, rollMax, map));
                System.arraycopy(state, 0, current, 0, 6);
            }
        }

        map.put(key, total);
        return total;
    }
}