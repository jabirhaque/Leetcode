class Cookies {
    public static void main(String[] args){
        System.out.println(distributeCookies(new int[]{8,15,10,20,8}, 2));
    }

    public static int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        return min(cookies, children, 0, Integer.MAX_VALUE);
    }

    private static int min(int[] cookies, int[] children, int i, int min){
        if (i == cookies.length){
            int max = 0;
            for (int n: children) max = Math.max(max, n);
            return Math.min(min, max);
        }
        for (int j=0; j<children.length; j++){
            if (cookies[i]+children[j]<min){
                cookies[i]+=children[j];
                min = min(cookies, children, i+1, min);
                cookies[i]-=children[j];
            }
        }
        return min;
    }
}