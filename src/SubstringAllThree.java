class SubstringAllThree {
    public static void main(String[] args){
        System.out.println(numberOfSubstrings("abcabc"));
    }

    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[][] prefix = new int[s.length()+1][3];
        for (int i=1; i<prefix.length; i++){
            prefix[i][0] = prefix[i-1][0]+(s.charAt(i-1)=='a'?1:0);
            prefix[i][1] = prefix[i-1][1]+(s.charAt(i-1)=='b'?1:0);
            prefix[i][2] = prefix[i-1][2]+(s.charAt(i-1)=='c'?1:0);
        }
        for (int i=0; i<s.length(); i++){
            int min = prefix.length;
            int l=i+1;
            int r=prefix.length-1;
            while (l<r){
                int m = (l+r)/2;
                if ((prefix[m][0]-prefix[i][0])>0 && (prefix[m][1]-prefix[i][1])>0 && (prefix[m][2]-prefix[i][2])>0){
                    min = Math.min(min, m);
                    r=m;
                }else{
                    l=m+1;
                }
            }
            if ((prefix[l][0]-prefix[i][0])>0 && (prefix[l][1]-prefix[i][1])>0 && (prefix[l][2]-prefix[i][2])>0){
                min = Math.min(min, l);
            }
            count += prefix.length-min;
        }
        return count;
    }
}