class MinFunctionCalls {
    public static void main(String[] args){
        System.out.println(minOperations(new int[]{1, 5}));
    }

    public static int minOperations(int[] nums) {
        int minusCount = 0;
        int halfCount = 0;
        for (int n: nums){
            if (n == 0) continue;
            String binary = Integer.toBinaryString(n);
            int lastOne = -1;
            for (int i=0; i<binary.length(); i++) if (binary.charAt(i) == '1'){
                lastOne = i;
                break;
            }
            int count = 0;
            for (int i=binary.length()-1; i>=lastOne; i--){
                if (binary.charAt(i) == '1') minusCount++;
                count++;
            }
            halfCount = Math.max(halfCount, count-1);
        }
        return halfCount+minusCount;
    }
}