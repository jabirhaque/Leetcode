class Versions {
    public static void main(String[] args){
        System.out.println(compareVersion("1.2", "1.10"));
    }
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i=0; i<Math.max(v1.length, v2.length); i++){
            int one = i<v1.length?Integer.valueOf(v1[i]):0;
            int two = i<v2.length?Integer.valueOf(v2[i]):0;
            if (one<two) return -1;
            if (two<one) return 1;
        }
        return 0;
    }
}
