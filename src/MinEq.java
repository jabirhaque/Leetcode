class MinEq {
    public static void main(String[] args){
        System.out.println(minSum(new int[]{20,0,18,11,0,0,0,0,0,0,17,28,0,11,10,0,0,15,29}, new int[]{16,9,25,16,1,9,20,28,8,0,1,0,1,27}));
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zero1 = 0;
        long sum2 = 0;
        int zero2 = 0;
        for (int n:nums1){
            sum1+=n;
            if (n == 0) zero1++;
        }
        for (int n:nums2){
            sum2+=n;
            if (n == 0) zero2++;
        }
        long min1 = sum1+zero1;
        long min2 = sum2+zero2;
        if (min1<min2){
            if (zero1 == 0) return -1;
            return min2;
        }
        if (min1!=min2 && zero2 == 0) return -1;
        return min1;
    }
}