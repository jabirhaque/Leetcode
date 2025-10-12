class DeleteChars {
    public static void main(String[] args){
        System.out.println(minDeletionSize(new String[]{"xga","xfb","yfa"}));
    }

    public static int minDeletionSize(String[] strs) {
        int count=0;
        for (int i=0; i<strs[0].length(); i++){
            int valid = 1;
            for (int j=1; j<strs.length; j++){
                if (strs[j].charAt(i) == strs[j-1].charAt(i)) valid = 0;
                if (strs[j].charAt(i) < strs[j-1].charAt(i)){
                    valid = -1;
                    break;
                }
            }
            if (valid == 1) return count;
            if (valid == -1) count++;
        }
        return count;
    }
}