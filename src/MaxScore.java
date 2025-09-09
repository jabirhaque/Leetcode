class MaxScore {
    public static void main(String[] args){
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
    }

    public static int maximumGain(String s, int x, int y) {
        int max = 0;
        for (int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == 'a' && s.charAt(i+1) == 'b'){
                String newString = s.substring(0, i) + s.substring(i+2);
                max = Math.max(max, x+maximumGain(newString, x, y));
            }
            if (s.charAt(i) == 'b' && s.charAt(i+1) == 'a'){
                String newString = s.substring(0, i) + s.substring(i+2);
                max = Math.max(max, y+maximumGain(newString, x, y));
            }
        }
        return max;
    }
}