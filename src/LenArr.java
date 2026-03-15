class LenArr {

    public static void main(String[] args){
        LenArr lenArr = new LenArr();
        lenArr.longestArithmetic(new int[]{9,7,5,10,1});
    }

    public int longestArithmetic(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        left[1] = 2;
        for (int i=2; i<nums.length; i++){
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) left[i] = 1+left[i-1];
            else left[i] = 2;
        }

        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        right[nums.length-2] = 2;
        for (int i=nums.length-3; i>=0; i--){
            if (nums[i]-nums[i+1] == nums[i+1]-nums[i+2]) right[i] = 1+right[i+1];
            else right[i] = 2;
        }

        int max = 2;

        for (int i=0; i<nums.length; i++){
            if (i > 1) max = Math.max(max, 1+left[i-1]);

            if (i<nums.length-2) max = Math.max(max, 1+right[i+1]);

            if (i>0 && i<nums.length-1){
                int diff = nums[i+1]-nums[i-1];
                if (diff%2 != 0) continue;
                diff /= 2;
                int curr = 3;
                if (i-1 > 0 && nums[i-1] - nums[i-2] == diff) curr += (left[i-1]-1);
                if (i+1 < nums.length-1 && nums[i+2]-nums[i+1] == diff) curr += (right[i+1]-1);
                max = Math.max(max, curr);
            }
        }

        return max;
    }
}