public class Strategy {
    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{5,4,3}, new int[]{1,1,0}, 2));
    }

    public static long maxProfit(int[] prices, int[] strategy, int k) {
        long total = 0;
        int[] multiply = new int[prices.length];
        for (int i=0; i<prices.length; i++){
            total+=prices[i]*strategy[i];
            multiply[i] = prices[i]*strategy[i];
        }
        long first = 0;
        for (int i=0; i<k; i++){
            first += multiply[i];
        }
        long max = total;
        long[] def = new long[prices.length-k+1];
        for (int i=0; i<def.length; i++){
            def[i] = first;
            first -= multiply[i];
            if (i+k<multiply.length){
                first += multiply[i+k];
            }
        }
        long[] compare = new long[prices.length-k+1];
        first = 0;
        for (int i=k/2; i<k; i++){
            first += prices[i];
        }
        for (int i=0; i<compare.length; i++){
            max = Math.max(max, total+(first-def[i]));
            compare[i] = first;
            first-=prices[i+k/2];
            if (i+k<prices.length){
                first+=prices[i+k];
            }
        }
        return max;
    }
}
