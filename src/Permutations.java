import java.util.ArrayList;
import java.util.List;

class Permutations {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args){
        List<List<Integer>> result = permute(new int[]{1,2,3});
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num: nums){
            list.add(num);
        }
        return recursion(list, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<Integer>> recursion(List<Integer> nums, List<Integer> current, List<List<Integer>> result){
        if (nums.size() == 0){
            result.add(current);
            return result;
        }
        for (int i=0; i<nums.size(); i++){
            int num = nums.get(i);
            List<Integer> newCurrent = new ArrayList<>();
            newCurrent.addAll(current);
            newCurrent.add(num);
            nums.remove(i);
            recursion(nums, newCurrent, result);
            nums.add(i, num);
        }
        return result;
    }
}