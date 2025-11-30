import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

class JumpGameNode{
    int index;
    int val;
    JumpGameNode(int index, int val){
        this.index = index;
        this.val = val;
    }
}

class JumpGame {
    public static void main(String[] args){
        System.out.println(maxResult(new int[]{1,-3,-1,-1,-3,-1,-1,1}, 2));
    }

    public static int maxResult(int[] nums, int k) {
        int[] res = new int[nums.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> res[b]-res[a]);
        res[nums.length-1] = nums[nums.length-1];
        queue.add(nums.length-1);
        for (int i=nums.length-2; i>=0; i--){
            while (queue.peek() > i+k) queue.poll();
            res[i] = nums[i] + res[queue.peek()];
            queue.add(i);
        }
        return res[0];
    }
}