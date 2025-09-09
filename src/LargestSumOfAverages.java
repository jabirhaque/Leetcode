class LargestSumOfAverages {
    public static void main(String[] args){
        System.out.println(largestSumOfAverages(new int[]{9,1,2,3,9}, 3));
    }

    public static double largestSumOfAverages(int[] nums, int k) {
        int[] prefix = new int[nums.length+1];
        for (int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1]+nums[i-1];
        }
        return recursion(prefix, 0, 0, 0, 0, k);
    }

    private static double recursion(int[] prefix, int i, int count, double current, double max, int k){
        if (count == k){
            if (i == prefix.length-1){
                return Math.max(max, current);
            }else{
                return max;
            }
        }
        for (int j=i+1; j<prefix.length; j++){
            double avg = (double)(prefix[j]-prefix[i])/(double)(j-i);
            max = Math.max(max, recursion(prefix, j, count+1, current+avg, max, k));
        }
        return max;
    }
}
