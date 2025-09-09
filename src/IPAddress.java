class IPAddress {
    public static void main(String[] args){
        System.out.println(validIPAddress("12..33.4"));
    }

    public static String validIPAddress(String queryIP) {
        if (ipv4(queryIP)){
            return "IPv4";
        }
        return "Neither";
    }

    private static boolean ipv4(String queryIP){
        for (char c: queryIP.toCharArray()){
            if (c != '.' && (c<'0' || c>'9')){
                return false;
            }
        }
        String[] strs = queryIP.split("\\.");
        if (strs.length != 4){
            return false;
        }
        for (String str: strs){
            if (Integer.valueOf(str)<0 || Integer.valueOf(str)>255 || !String.valueOf(Integer.valueOf(str)).equals(str)){
                return false;
            }
        }
        return true;
    }
}