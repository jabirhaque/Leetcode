class Magic {
    public static void main(String[] args){
        System.out.println(magicalString(100));
    }

    public static String magicalString(int n) {
        String magic = generate(n, "122", 2);
        return magic;
    }

    private static String generate(int n, String str, int i){
        if (str.length()>n){
            return str;
        }
        int freq = str.charAt(i)-'0';
        char c = str.charAt(str.length()-1) == '1'?'2':'1';
        for (int j=0; j<freq; j++){
            str+=c;
        }
        return generate(n, str, i+1);
    }
}