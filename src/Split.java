class Split {
    public static void main(String[] args){
        System.out.println(waysToSplit(new int[]{1,3,9,3,10,5,7,7}));
    }

    public static int waysToSplit(int[] nums) {
        int[] prefix = new int[nums.length+1];
        for (int i=1; i<prefix.length; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        long count = 0;
        for (int i=1; i<prefix.length-1; i++){
            int min = Integer.MAX_VALUE;
            int l=i+1;
            int r=prefix.length-2;
            while (l<r){
                int m = (l+r)/2;
                if (prefix[m]-prefix[i]>=prefix[i]){
                    min = Math.min(min, m);
                    r = m-1;
                }else{
                    l = m+1;
                }
            }
            if (prefix[l]-prefix[i]>=prefix[i]){
                min = Math.min(min, l);
            }
            int max = -1;
            l=i+1;
            r = prefix.length-2;
            while (l<r){
                int m = (l+r)/2;
                if (prefix[prefix.length-1]-prefix[m]>=prefix[m]-prefix[i]){
                    max = Math.max(max, m);
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            if (prefix[prefix.length-1]-prefix[l]>=prefix[l]-prefix[i]){
                max = Math.max(max, l);
            }
            if (min != Integer.MAX_VALUE && max != -1){
                count += Math.max(0, max-min+1);
            }
        }
        return (int) (count%1000000007);
    }
}