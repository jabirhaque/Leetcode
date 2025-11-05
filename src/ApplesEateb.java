import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ApplesEateb {
    public static void main(String[] args){
        System.out.println(eatenApples(new int[]{3,0,1,5,9,7,3,1,0,1}, new int[]{9,0,3,1,5,9,6,3,0,7}));
    }

    public static int eatenApples(int[] apples, int[] days) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i = 0;
        while (i<apples.length || !queue.isEmpty()){
            if (i<apples.length && apples[i]>0){
                queue.add(i+days[i]);
                map.put(i+days[i], map.getOrDefault(i+days[i], 0)+apples[i]);
            }
            if (!queue.isEmpty()){
                if (queue.peek() <= i || map.get(queue.peek()) == 0) queue.poll();
                else{
                    map.put(queue.peek(), map.get(queue.peek())-1);
                    count++;
                    i++;
                }
            }else i++;
        }
        return count;
    }
}