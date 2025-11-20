class Ktransactions {
    public static void main(String[] args){
        System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}));
    }

    public static int maxProfit(int k, int[] prices) {
        int[] sell = new int[prices.length];
        sell[prices.length-1] = prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--){
            sell[i] = Math.max(sell[i+1], prices[i]);
        }
        int[] transaction = new int[prices.length];
        transaction[prices.length-1] = sell[prices.length-1]-prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--){
            transaction[i] = Math.max(transaction[i+1], sell[i]-prices[i]);
        }
        k--;
        while (k>0){
            transaction = transaction(prices, transaction);
            k--;
        }
        return transaction[0];
    }

    private static int[] transaction(int[] prices, int[] transaction){
        int[] newSell = new int[prices.length];
        newSell[prices.length-1] = prices[prices.length-1]+transaction[prices.length-1];
        for (int i=prices.length-2; i>=0; i--){
            newSell[i] = Math.max(newSell[i+1], prices[i]+transaction[i]);
        }
        int[] newTransaction = new int[prices.length];
        newTransaction[prices.length-1] = newSell[prices.length-1]-prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--){
            newTransaction[i] = Math.max(newTransaction[i+1], newSell[i]-prices[i]);
        }
        return newTransaction;
    }
}