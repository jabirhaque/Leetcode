import java.util.*;

class MaximumPair {
    public static void main(String[] args){
        System.out.println(minimizeMax(new int[]{1,1,0,3}, 2)); //0,1,1,3
    }

    public static int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a)-map.get(b));
        for (int i=0; i<nums.length-1; i++) {
            map.put(i, nums[i+1]-nums[i]);
            queue.add(i);
        }
        Set<Integer> set = new HashSet<>();
        int max = 0;
        while (p>0){
            int i = queue.poll();
            if (set.contains(i) || set.contains(i+1)) continue;
            max = Math.max(max, map.get(i));
            set.add(i);
            set.add(i+1);
            p--;
        }
        return max;
    }
}
