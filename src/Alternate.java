import java.util.*;

class Alternate {
    public static void main(String[] args){
        System.out.println(minimumOperations(new int[]{1,1,1,1,1}));
    }

    public static int minimumOperations(int[] nums) {
        if (nums.length == 1) return 0;
        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd = new HashMap<>();
        int e = nums.length-nums.length/2;
        int o = nums.length/2;
        for (int i=0; i<nums.length; i++){
            if (i%2 == 0) even.put(nums[i], even.getOrDefault(nums[i], 0)+1);
            else odd.put(nums[i], odd.getOrDefault(nums[i], 0)+1);
        }
        List<Integer> evenList = new ArrayList<>(even.keySet());
        List<Integer> oddList = new ArrayList<>(odd.keySet());
        Collections.sort(evenList, (a, b) -> even.get(b)-even.get(a));
        Collections.sort(oddList, (a, b) -> odd.get(b)-odd.get(a));
        evenList.add(-1);
        oddList.add(-1);
        if (evenList.get(0) != oddList.get(0)) return e-even.get(evenList.get(0)) + o-odd.get(oddList.get(0));
        int optionOne = e-even.get(evenList.get(0)) + o-odd.getOrDefault(oddList.get(1), 0);
        int optionTwo = e-even.getOrDefault(evenList.get(1), 0) + o-odd.get(oddList.get(0));
        return Math.min(optionOne, optionTwo);
    }
}