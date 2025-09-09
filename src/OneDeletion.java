public class OneDeletion {
    public static void main(String[] args){
        System.out.println(maximumSum(new int[]{11,-10,-11,8,7,-6,9,4,11,6,5,0}));
    }

    public static int maximumSum(int[] arr) {
        int max = arr[0];
        int lp = 0;
        int ln = 0;
        for (int i=0; i<arr.length; i++){
            int c = arr[i];
            if (i == 0){
                lp = c;
                ln = Math.min(c, 0);
                continue;
            }
            max = Math.max(Math.max(max, c), Math.max(lp, c+lp-ln));
            if (c == Math.max(c+lp-ln, lp)){
                if (Math.min(c, 0) > ln){
                    lp = c;
                    ln = Math.min(c, 0);
                }else{
                    lp = c+lp;
                    ln = Math.min(ln, c);
                }
            }
            else if (c>Math.max(c+lp-ln, lp)){ // watch when equal
                lp = c;
                ln = Math.min(c, 0);
            }else{
                lp = c+lp;
                ln = Math.min(ln, c);
            }
        }
        return max;
    }
}
