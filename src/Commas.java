class Commas {
    public static void main(String[] args){
        Commas commas = new Commas();
        commas.countCommas(1409752114);
    }
    public long countCommas(long n) {
        if (n < 1000) return 0;
        long count = 0;
        int length = String.valueOf(n).length();
        int maxLen = 6;
        int minLen = 4;
        while (minLen <= length){
            long max = Math.min(n, nines(maxLen));
            long min = min(minLen);
            long freq = max - min + 1;
            int commas = (minLen-1)/3;
            count += freq*commas;
            maxLen+=3;
            minLen+=3;
        }
        return count;
    }

    private long nines(int len){
        String str = "";
        while (len>0){
            str += '9';
            len--;
        }
        return Long.valueOf(str);
    }

    private long min(int n){
        String str = "1";
        while (n>1){
            str += '0';
            n--;
        }
        return Long.valueOf(str);
    }
}