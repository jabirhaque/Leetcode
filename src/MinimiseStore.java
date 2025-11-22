class MinimiseStore {
    public static void main(String[] args){
        System.out.println(minimizedMaximum(6, new int[]{11, 6}));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = quantities[0];
        for (int i: quantities) r = Math.max(r, i);
        int min = r;
        while (l<r){
            int m = (l+r)/2;
            if (valid(n, quantities, m)){
                min = m;
                r=m;
            }else{
                l=m+1;
            }
        }
        if (valid(n, quantities, l)) min = l;
        return min;
    }

    private static boolean valid(int n, int[] quantities, int capacity){
        int stores = 0;
        for (int i: quantities) stores += Math.ceil((float)i/capacity);
        return stores<=n;
    }
}