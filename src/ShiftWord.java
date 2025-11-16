class ShiftWord {
    public static void main(String[] args){
        System.out.println(shiftDistance("leet", "code", new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }

    public static long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[] prefixNext = new long[26];
        long[] prefixPrev = new long[26];
        prefixNext[0] = nextCost[0];
        prefixPrev[0] = previousCost[0];
        for (int i=1; i<26; i++){
            prefixNext[i] = prefixNext[i-1] + nextCost[i];
            prefixPrev[i] = prefixPrev[i-1] + previousCost[i];
        }
        long total = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == t.charAt(i)) continue;
            if (s.charAt(i) < t.charAt(i)){
                long including = prefixNext[t.charAt(i)-1-'a'];
                long excluding = s.charAt(i)-1-'a' == -1 ? 0 : prefixNext[s.charAt(i)-1-'a'];
                long min = including - excluding;

                long firstHalf = prefixPrev[s.charAt(i)-'a'];
                long secondHalf = prefixPrev[25] - prefixPrev[t.charAt(i)-'a'];
                total += Math.min(min, firstHalf+secondHalf);
            }else{
                long including = prefixPrev[s.charAt(i)-'a'];
                long excluding = prefixPrev[t.charAt(i)-'a'];
                long min = including - excluding;

                long firstHalf = prefixNext[25] - (s.charAt(i)-'a'-1 == -1 ? 0 : prefixNext[s.charAt(i)-'a'-1]);
                long secondHalf = t.charAt(i)-'a'-1 == -1 ? 0 : prefixNext[t.charAt(i)-'a'-1];
                total += Math.min(min, firstHalf+secondHalf);
            }
        }
        return total;
    }
}