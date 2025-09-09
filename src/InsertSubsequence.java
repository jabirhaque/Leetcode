public class InsertSubsequence {
    public static void main(String[] args){
        System.out.println(substring("LCLCTTT"));
    }

    private static long substring(String s){
        long[] tAfter = new long[s.length()+1];
        long[] cAfter = new long[s.length()+1];
        long[] lAfter = new long[s.length()+1];
        for (int i=s.length()-1; i>=0; i--){
            tAfter[i] = tAfter[i+1] + (s.charAt(i)=='T'?1:0);
        }
        for (int i=s.length()-1; i>=0; i--){
            cAfter[i] = cAfter[i+1] + (s.charAt(i)=='C'?tAfter[i+1]:0);
        }
        for (int i=s.length()-1; i>=0; i--){
            lAfter[i] = lAfter[i+1] + (s.charAt(i)=='L'?cAfter[i+1]:0);
        }
        return lAfter[0];
    }
}
