import java.util.Arrays;

public class AmazonDiscount {
    public static void main(String[] args){
        System.out.println(findMinPrice(new int[] {9,11,13,15,17}, 2, 6));
        System.out.println(findMinPrice(new int[] {1,1,1}, 1, 3));
    }

    public static int findMinPrice(int[] cost, int k, int pairCost){
        if (cost.length == 0){
            return 0;
        }if (cost.length == 1){
            return cost[0];
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(min, cost[0]+findMinPrice(Arrays.copyOfRange(cost, 1, cost.length), k, pairCost));
        min = Math.min(min, cost[cost.length-1]+findMinPrice(Arrays.copyOfRange(cost, 0, cost.length-1), k, pairCost));
        if (k>0){
            min = Math.min(min, pairCost+findMinPrice(Arrays.copyOfRange(cost, 1, cost.length-1), k-1, pairCost));
        }
        return min;
    }
}
