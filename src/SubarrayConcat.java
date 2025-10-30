class SubarrayConcat {
    public static void main(String[] args){
        System.out.println(canChoose(new int[][]{{1,2,3}, {3,4}}, new int[] {7,7,1,2,3,4,7,7}));
    }

    public static boolean canChoose(int[][] groups, int[] nums) {
        int min = 0;
        for (int[] group: groups){
            boolean solved = false;
            int i=min;
            if (i == nums.length) return false;
            while (i<nums.length){
                int j=0;
                while (j<group.length && i+j<nums.length){
                    if (group[j] == nums[i+j]) j++;
                    else break;
                }
                i++;
                if (j==group.length) {
                    i+=j-1;
                    solved = true;
                    break;
                }
            }
            min = i;
            if (!solved) return false;
        }
        return true;
    }
}