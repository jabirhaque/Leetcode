
class MinBea {

    static int mod = 1000000007;

    public static void main(String[] args){
        System.out.println(minimumPossibleSum(2,3));
    }

    public static us int minimumPossibleSum(int n, int target) {
        long count = 0;
        int lessMax = Math.min(n, target / 2);
        count = (count + (long) lessMax * (lessMax + 1) / 2) % mod;
        n -= lessMax;
        if (n == 0) return (int) count;
        int moreMax = target + n - 1;
        long add = ((long) moreMax * (moreMax + 1) / 2 - (long) (target - 1) * target / 2) % mod;
        count = (count + add) % mod;
        if (count < 0) count += mod;
        return (int) count;
    }
}