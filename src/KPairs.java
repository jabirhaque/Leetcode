import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class KPairs {
    public static void main(String[] args){
        System.out.println(kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        boolean[][] map = new boolean[nums1.length][nums2.length];
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> nums1[a.get(0)]+nums2[a.get(1)] - nums1[b.get(0)]+nums2[b.get(1)]);
        List<Integer> current = List.of(0, 0);
        while (true){
            result.add(current);
            if (current.get(0)+1<nums1.length && !map[current.get(0)+1][current.get(1)]){
                queue.add(List.of(current.get(0)+1, current.get(1)));
                map[current.get(0)+1][current.get(1)] = true;
            }
            if (current.get(1)+1<nums2.length && !map[current.get(0)][current.get(1)+1]){
                queue.add(List.of(current.get(0), current.get(1)+1));
                map[current.get(0)][current.get(1)+1] = true;
            }
            if (queue.isEmpty() || result.size() == k) break;
            current = queue.poll();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> list: result){
            res.add(List.of(nums1[list.get(0)], nums2[list.get(1)]));
        }
        return res;
    }
}