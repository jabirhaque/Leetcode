class RotateBin {
    public static void main(String[] args){
        System.out.println(search(new int[]{5,1,3}, 1));
    }

    public static int search(int[] nums, int target) {
        int maxIndex = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        maxIndex = l;
        if (nums[maxIndex] == target) return maxIndex;
        l = 0;
        r = 0;
        if (maxIndex!=0 && target>=nums[0] && target<=nums[maxIndex-1]){
            r = maxIndex-1;
        }else if (maxIndex!=nums.length-1 && target>=nums[maxIndex+1] && target<=nums[nums.length-1]){
            l = maxIndex+1;
            r = nums.length-1;
        }else return -1;
        while (l<r){
            int m = (l+r)/2;
            if (nums[m] == target) return m;
            if (target < nums[m]) r = m;
            else l = m+1;
        }
        if (l<nums.length && nums[l] == target) return l;
        return -1;
    }
}