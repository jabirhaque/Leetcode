class Min {
    public static void main(String[] args){
        System.out.println(findMin(new int[] {4,5,1,2,3}));
    }

    public static int findMin(int[] nums) {
        if (nums.length<3){
            int min = Integer.MAX_VALUE;
            for (int n: nums){
                min = Math.min(min, n);
            }
            return min;
        }
        int mid = (nums.length-1)/2;
        int lstart = 0;
        int lend = mid;
        while (lstart<lend){
            int m = (lstart+lend)/2;
            if (m == 0){
                if (nums[m]<nums[1]){
                    lend = m;
                }else{
                    lstart = m+1;
                }
            }else if (nums[m]>nums[m-1] && nums[m]>nums[m+1]){
                boolean l = nums[m-1]<nums[m+1];
                if (l){
                    lend = m;
                }else{
                    lstart = m;
                }
            }else if (nums[m]>nums[m-1]){
                lend = m;
            }else{
                lstart = m;
            }
        }
        int left = nums[lstart];
        int rstart = mid;
        int rend = nums.length-1;
        while (rstart<rend){
            int m = (rstart+rend)/2;
            if (m != rstart && nums[m]>nums[m-1] && nums[m]>nums[m+1]){
                boolean l = nums[m-1]<nums[m+1];
                if (l){
                    rend = m;
                }else{
                    rstart = m;
                }
            }else if (m != rstart && nums[m]>nums[m-1]){
                rend = m;
            }else if (nums[m]>nums[m+1]){
                rstart = m+1;
            }else{
                rend = m;
            }
        }
        int right = nums[rstart];
        return Math.min(left, right);
    }
}