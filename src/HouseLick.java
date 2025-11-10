class HouseLick {
    public static void main(String[] args){
        System.out.println(minCapability(new int[]{2,3,5,9}, 2));
    }

    public static int minCapability(int[] nums, int k) {
        int l = 0;
        int r = nums[0];
        for (int i=0; i<nums.length; i++){
            l = Math.min(l, nums[i]);
            r = Math.max(r, nums[i]);
        }
        int min = r;
        while (l<r){
            int m = (l+r)/2;
            if (valid(nums, k, m)){
                min = Math.min(min, m);
                r=m;
            }
            else l=m+1;
        }
        if (valid(nums, k, l)) min = Math.min(min, l);
        return min;
    }

    private static boolean valid(int[] nums, int k, int max){
        int i=0;
        while (i<nums.length && k>0){
            if (nums[i]<=max){
                k--;
                i++;
            }
            i++;
        }
        return k==0;
    }
}