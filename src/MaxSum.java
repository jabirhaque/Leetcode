class MaxSum {
    public static void main(String[] args){
        System.out.println(maxValue(4,3,4)); //[1,1,1,2]
    }
    public static int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        int max = 1;
        while (l<r){
            int m = (l+r)/2;
            long min = min(n, index, m);
            if (min<=maxSum){
                max = m;
                l = m+1;
            }else{
                r = m;
            }
        }
        long min = min(n, index, l);
        if (min<=maxSum) max = l;
        return max;
    }

    private static long min(int n, int index, int val){
        int leftSpaces = index;
        int rightSpaces = n-index-1;
        long left = ((long)val*(long)(val-1))/2;
        long right = ((long)val*((long)val-1))/2;
        if (leftSpaces<val-1){
            left -= ((long)(val-leftSpaces)*(long)(val-leftSpaces-1))/2;
        }else{
            left += leftSpaces-val+1;
        }
        if (rightSpaces<val-1){
            right -= ((long)(val-rightSpaces)*(long)(val-rightSpaces-1))/2;
        }else{
            right += rightSpaces-val+1;
        }
        return left+right+val;
    }
}