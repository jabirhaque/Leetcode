import java.util.HashMap;
import java.util.Map;

class Coin {
    public static void main(String[] args){
        System.out.println(coinChange(new int[] {186, 419, 83, 408}, 6249));
    }

    public static int coinChange(int[] coins, int amount){
        return recursion(coins, amount, new HashMap<>());
    }

    private static int recursion(int[] coins, int amount, Map<Integer, Integer> map){
        if (map.containsKey(amount)){
            return map.get(amount);
        }
        if (amount<0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int coin: coins){
            if (coin>amount){
                int value = recursion(coins, amount-coin, map);
                if (value!=-1){
                    min = Math.min(min, value+1);
                }
            }else{
                int value = recursion(coins, amount%coin, map);
                if (value!=-1){
                    min = Math.min(min, value+amount/coin);
                }
            }
        }
        int result = min == Integer.MAX_VALUE?-1:min;
        map.put(amount, result);
        return result;
    }
}