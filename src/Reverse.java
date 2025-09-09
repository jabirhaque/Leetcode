class Reverse {
    public static void main(String[] args){
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        boolean neg = x<0;
        char[] chars = String.valueOf(x).toCharArray();
        String reverse = "";
        for (int i=chars.length-1; i>=0; i--){
            if (chars[i] != '-'){
                reverse+=chars[i];
            }
        }
        long res = Long.valueOf(reverse);
        if (res>Integer.MAX_VALUE){
            return 0;
        }
        return neg?-1*Integer.valueOf(reverse):Integer.valueOf(reverse);
    }
}