import java.util.*;

class MaxEqualFreq {
    public static void main(String[] args) {
        System.out.println(maxEqualFreq(new int[]{1, 1, 1, 2, 2, 2}));
    }

    public static int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> digits = new HashMap<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (digits.containsKey(nums[i])) {
                int freq = digits.get(nums[i]);
                if (frequencies.getOrDefault(freq, 0) == 1) frequencies.remove(freq);
                else frequencies.put(freq, frequencies.get(freq) - 1);
                frequencies.put(freq + 1, frequencies.getOrDefault(freq + 1, 0) + 1);
            } else {
                frequencies.put(1, frequencies.getOrDefault(1, 0) + 1);
            }
            digits.put(nums[i], digits.getOrDefault(nums[i], 0) + 1);
            if (digits.size() == 1) {
                max = i + 1;
            }
            if (frequencies.size() == 1 && frequencies.getOrDefault(1, 0) > 0) max = i + 1;
            if (frequencies.size() == 2) {
                List<Integer> list = new ArrayList<>(frequencies.keySet());
                Collections.sort(list);
                if (list.get(0) == 1 && frequencies.get(1) == 1 || list.get(1) == list.get(0)+1 && frequencies.get(list.get(1)) == 1) max = i + 1;
            }
        }
        return max;
    }
}