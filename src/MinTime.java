class MinTime {
    public static void main(String[] args){
        System.out.println(minTime("xy", new int[]{0,1}, 4));
    }

    public static int minTime(String s, int[] order, int k) {
        if ((((long)s.length()*((long)s.length()+1))/(long)2)<k) return -1;
        int l=0;
        int r=s.length()-1;
        int min = s.length()-1;
        while (l<r){
            char[] list = s.toCharArray();
            int m=(l+r)/2;
            for (int i=0; i<=m; i++){
                list[order[i]] = '*';
            }
            if (substring(list, k)){
                min = Math.min(min, m);
                r=m;
            }else{
                l=m+1;
            }
        }
        char[] list = s.toCharArray();
        for (int i=0; i<=l; i++){
            list[order[i]] = '*';
        }
        if (substring(list, k)){
            min = Math.min(min, l);
        }
        return min;
    }

    private static boolean substring(char[] list, int k){
        long total = ((long)list.length*((long)list.length+1))/(long)2;
        int last = -1;
        for (int i=0; i<=list.length; i++){
            if (i == list.length || list[i] == '*'){
                int len = i-last-1;
                total -= ((long)len*((long)len+1))/(long)2;
                last = i;
            }
        }
        return total>=k;
    }
}