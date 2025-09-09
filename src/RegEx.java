class RegEx {
    public static void main(String[] args){
        System.out.println(isMatch("aaca", "ab*a*c*a"));
    }

    public static boolean isMatch(String s, String p) {
        return recursion(s, p, 0, "");
    }

    private static boolean recursion(String s, String p, int i, String str){
        if (i>=p.length() || str.length()>s.length()){
            return i==p.length() && str.equals(s);
        }
        if (i+1<p.length() && p.charAt(i+1) == '*'){
            if (recursion(s, p, i+2, str)){
                return true;
            }
            if (p.charAt(i) == '.'){
                while (str.length()<s.length()){
                    str+=s.charAt(str.length());
                    if (recursion(s, p, i+2, str)){
                        return true;
                    }
                }
            }else{
                while (str.length()<s.length()){
                    str+=p.charAt(i);
                    if (recursion(s, p, i+2, str)){
                        return true;
                    }
                }
            }
        }else{
            if (p.charAt(i) == '.'){
                if (str.length()<s.length() && recursion(s, p, i+1, str+s.charAt(str.length()))){
                    return true;
                }
            }else{
                if (recursion(s, p, i+1, str+p.charAt(i))){
                    return true;
                }
            }
        }
        return false;
    }
}