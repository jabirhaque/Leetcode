class FairArray {
    public static void main(String[] args){
        System.out.println(waysToMakeFair(new int[]{2,1,6,4}));
    }
    public static int waysToMakeFair(int[] nums) {
        int[][] left = new int[nums.length][2];
        int[][] right = new int[nums.length][2];
        for (int i=1; i<nums.length; i++){
            left[i] = new int[]{left[i-1][0]+((i-1)%2==0?nums[i-1]:0), left[i-1][1]+((i-1)%2==1?nums[i-1]:0)};
        }
        for (int i=nums.length-2; i>=0; i--){
            right[i] = new int[]{right[i+1][0]+((i+1)%2==0?nums[i+1]:0), right[i+1][1]+((i+1)%2==1?nums[i+1]:0)};
        }
        int count = 0;
        for (int i=0; i<nums.length; i++){
            if (left[i][0]+right[i][1]==left[i][1]+right[i][0]){
                count++;
            }
        }
        return count;
    }
}