import java.util.*;

class ConsecSplit {
    public static void main(String[] args){
        System.out.println(isPossible(new int[]{1,2,3,5,5,6,7}));
    }

    public static boolean isPossible(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums){
            queue.add(n);
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        List<List<Integer>> subsequences = new ArrayList<>();
        while (!queue.isEmpty()){
            int smallest = queue.peek();
            int curr = smallest;
            while (map.containsKey(curr)){
                if (map.get(curr) == 1) map.remove(curr);
                else map.put(curr, map.get(curr)-1);
                queue.remove(curr);
                curr++;
            }
            subsequences.add(new ArrayList<>(List.of(smallest, curr-1)));
        }
        for (int i=0; i<subsequences.size(); i++){
            List<Integer> sub = subsequences.get(i);
            int j = 0;
            while (sub.get(1)-sub.get(0)<2 && j<subsequences.size()){
                List<Integer> donor = subsequences.get(j);
                if (sub.get(0)>donor.get(0) && sub.get(0)<donor.get(1) && donor.get(1)-sub.get(0) >= 2){
                    int temp = sub.get(0);
                    sub.set(0, donor.get(0));
                    donor.set(1, temp);
                }else if (sub.get(1)>donor.get(0) && sub.get(1)<donor.get(1) && sub.get(1)-donor.get(0) >= 2){
                    int temp = sub.get(1);
                    sub.set(1, donor.get(1));
                    donor.set(1, temp);
                }
                j++;
            }
            if (sub.get(1)-sub.get(0)<2) return false;
        }
        return true;
    }
}