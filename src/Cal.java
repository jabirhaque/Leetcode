class Cal {
    public static void main(String[] args){
        System.out.println(calculate(" 2-1 + 2 "));
    }

    public static int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) if (c!=' ' && c!='(' && c!=')') sb.append(c);
        String str = sb.toString();
        sb = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            if (i+1<str.length() && str.charAt(i) == '-' && str.charAt(i+1) == '-') {
                sb.append('+');
                i++;
            }else sb.append(str.charAt(i));
        }
        str = sb.toString();
        if (str.charAt(0) == '-') str = '0'+str;
        int i = 0;
        while (i<str.length() && (str.charAt(i) != '+' && str.charAt(i) != '-')) i++;
        int res = Integer.valueOf(str.substring(0, i));
        while (i<str.length()){
            int j = i+1;
            while (j<str.length() && (str.charAt(j)!= '+' && str.charAt(j)!='-')) j++;
            if (str.charAt(i) == '+') res += Integer.valueOf(str.substring(i+1, j));
            else res -= Integer.valueOf(str.substring(i+1, j));
            i=j;
        }
        return res;
    }
}