class ArithmaticSlices {
    public static void main(String[] args){
        System.out.println(numberOfArithmeticSlices(new int[]{1,2,3,4,8,9,10}));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int[] diff = new int[nums.length];
        diff[0] = Integer.MAX_VALUE;
        for (int i=1; i<nums.length; i++){
            diff[i] = nums[i]-nums[i-1];
        }
        int l=0;
        int r=0;
        int res = 0;
        while (r<=nums.length){
            if (r<nums.length && diff[r] == diff[l]){
                r++;
            }else{
                int length = r-l;
                res += length*(length-1)/2;
                l = r;
                if (r == nums.length){
                    r++;
                }
            }
        }
        return res;
    }
}