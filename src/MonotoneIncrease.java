class MonotoneIncrease {
    public static void main(String[] args){
        System.out.println(monotoneIncreasingDigits(332));
    }

    public static int monotoneIncreasingDigits(int n) {
        return Integer.valueOf(dfs(String.valueOf(n), 0, '0', false));
    }

    private static String dfs(String n, int i, char prev, boolean decremented){
        if (i==n.length()) return "";
        char min = prev;
        char max;
        if (decremented) max = '9';
        else max = n.charAt(i);
        for (char c=max; c>=min; c--){
            String res = dfs(n, i+1, c, decremented||c<n.charAt(i));
            if (!res.equals(".")) return c+res;
        }
        return ".";
    }
}