import java.util.LinkedList;
import java.util.Queue;

class Swap {
    public static void main(String[] args){
        System.out.println(minSwaps(new int[]{2,4,5,7}));
    }

    public static int minSwaps(int[] nums) {
        Queue<Integer> even = new LinkedList<>();
        Queue<Integer> odd = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]%2 == 0) even.add(i);
            else odd.add(i);
        }
        if (Math.abs(even.size()-odd.size())>1) return -1;
        int evenFirst = evenFirst(nums, even, odd);
        int oddFirst = oddFirst(nums, even, odd);
        if (evenFirst != -1 && (oddFirst == -1 || evenFirst<oddFirst)) return evenFirst;
        return oddFirst;
    }

    private static int evenFirst(int[] nums, Queue<Integer> e, Queue<Integer> o){
        Queue<Integer> even = new LinkedList<>(e);
        Queue<Integer> odd = new LinkedList<>(o);
        int count = 0;
        for (int i=0; i<nums.length; i++){
            if (i%2 == 0){
                if (even.isEmpty()) return -1;
                count += Math.max(0, even.poll()-i);
            }else{
                if (odd.isEmpty()) return -1;
                count += Math.max(0, odd.poll()-i);
            }
        }
        return count;
    }

    private static int oddFirst(int[] nums, Queue<Integer> e, Queue<Integer> o){
        Queue<Integer> even = new LinkedList<>(e);
        Queue<Integer> odd = new LinkedList<>(o);
        int count = 0;
        for (int i=0; i<nums.length; i++){
            if (i%2 == 1){
                if (even.isEmpty()) return -1;
                count += Math.max(0, even.poll()-i);
            }else{
                if (odd.isEmpty()) return -1;
                count += Math.max(0, odd.poll()-i);
            }
        }
        return count;
    }
}