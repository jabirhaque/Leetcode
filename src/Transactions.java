import java.util.*;

public class Transactions {

    public static void main(String[] args){
        System.out.println(invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}));
    }

    public static List<String> invalidTransactions(String[] transactions) {
        //assuming it is sorted by time, if not you need to use a custom sort
        Set<Integer> res = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i< transactions.length; i++){
            String transaction = transactions[i];
            int time = Integer.valueOf(transaction.split(",")[1]);
            if (Integer.valueOf(transaction.split(",")[2])>1000){
                res.add(i);
            }
            while (!q.isEmpty() && Integer.valueOf(transactions[q.peek()].split(",")[1]) < time-60){
                q.remove();
            }
            for (int j:q){
                String t = transactions[j];
                if (t.split(",")[0].equals(transaction.split(",")[0]) && !t.split(",")[3].equals(transaction.split(",")[3])){
                    res.add(j);
                    res.add(i);
                }
            }
            q.add(i);
        }
        List<String> list = new ArrayList<>();
        for (int i: res){
            list.add(transactions[i]);
        }
        return list;
    }

}
