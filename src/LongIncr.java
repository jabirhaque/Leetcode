class LongIncr {
    public static void main(String[] args){
        System.out.println(findNumberOfLIS(new int[]{1,3,5,4,7}));
    }

    public static int findNumberOfLIS(int[] nums) {
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        length[nums.length-1] = 1;
        count[nums.length-1] = 1;
        for (int i=nums.length-2; i>=0; i--){
            length[i] = 1;
            count[i] = 1;
            for (int j=i+1; j<nums.length; j++){
                if (nums[j]>nums[i]){
                    if (1+length[j] > length[i]){
                        length[i] = 1+length[j];
                        count[i] = count[j];
                    }
                    else if (1+length[j] == length[i]){
                        count[i]+=count[j];
                    }
                }
            }
        }
        int max = 0;
        int freq = 0;
        for (int i=0; i<nums.length; i++){
            if (length[i] > max){
                max = length[i];
                freq = count[i];
            }
            else if (length[i] == max){
                freq += count[i];
            }
        }
        return freq;
    }
}