import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CommonWord {
    public static void main(String[] args){
        System.out.println(mostCommonWord("Bob. hIt, baLl" , new String[]{"hit", "bob"}));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[\\p{Punct}]", " ").toLowerCase().split(" ");
        Set<String> set = new HashSet<>();
        for (String ban: banned){
            set.add(ban);
        }
        set.add("");
        String result = "";
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            if (!set.contains(word)){
                if (map.containsKey(word)){
                    map.replace(word, map.get(word)+1);
                }else{
                    map.put(word, 1);
                }
                if (map.get(word)>max){
                    max = map.get(word);
                    result = word;
                }
            }
        }
        return result;
    }
}