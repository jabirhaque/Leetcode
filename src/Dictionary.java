public class Dictionary {

    public static void main(String[] args){
        System.out.println(search("judge", new String[]{"hello","hallo","leetcode","judge"}));
    }

    private static boolean search(String searchWord, String[] words) {
        for (String word: words){
            if (word.length() != searchWord.length()){
                continue;
            }
            int count = 0;
            for (int i=0; i<searchWord.length(); i++){
                if (searchWord.charAt(i) != word.charAt(i)){
                    count++;
                }
            }
            if (count == 1){
                return true;
            }
        }
        return false;
    }
}
