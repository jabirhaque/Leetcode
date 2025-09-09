import java.util.HashMap;
import java.util.Map;

class Secret {
    public static void main(String[] args){
        System.out.println(peopleAwareOfSecret(6, 2, 4));
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int knows = 1;
        int talking = 0;
        Map<Integer, Integer> waiting = new HashMap<>();
        Map<Integer, Integer> telling = new HashMap<>();
        for (int i=1; i<=delay; i++) waiting.put(i, 0);
        for (int i=1; i<=forget-delay; i++) telling.put(i, 0);
        waiting.put(delay, 1);
        int m=1;
        while (m<n){
            int temp = telling.get(forget-delay);
            for (int i=forget-delay; i>1; i--){
                int prev = telling.get(i-1);
                telling.put(i-1, temp);
                temp = prev;
            }
            knows -= temp;
            talking -= temp;
            temp = waiting.get(delay);
            for (int i=delay; i>1; i--){
                int prev = waiting.get(i-1);
                waiting.put(i-1, temp);
                temp = prev;
            }
            telling.put(forget-delay, temp);
            talking += temp;
            waiting.put(delay, talking);
            knows += talking;
            m++;
        }
        return knows;
    }
}