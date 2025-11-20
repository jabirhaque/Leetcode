class Capacity {
    public static void main(String[] args){
        System.out.println(shipWithinDays(new int[]{1,2,3,1,1}, 4));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int l = 0;
        int r = 0;
        for (int n: weights) {
            l = Math.max(l, n);
            r += n;
        }
        int min = r;
        while (l<r){
            int m = (l+r)/2;
            if (valid(weights, days, m)){
                min = m;
                r=m;
            }else{
                l=m+1;
            }
        }
        if (valid(weights, days, l)) min = l;
        return min;
    }

    private static boolean valid(int[] weights, int days, int capacity){
        int count = 0;
        int current = 0;
        for (int i=0; i<weights.length; i++){
            if (current + weights[i] > capacity){
                current = weights[i];
                count++;
            }else current += weights[i];
        }
        return count+1<=days;
    }
}