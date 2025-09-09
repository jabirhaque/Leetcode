import java.util.*;

class Substring {
    public static void main(String[] args){
        System.out.println(findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            if (map.containsKey(word)){
                map.replace(word, map.get(word)+1);
            }else{
                map.put(word, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<words[0].length(); i++){
            Map<String, Integer> compareMap = new HashMap<>();
            for (int j=0; j<words.length; j++){
                if (i+(j+1)*words[0].length()>s.length()){
                    return result;
                }
                String str = s.substring(i+j*words[0].length(), i+(j+1)*words[0].length());
                compareMap.put(str, compareMap.getOrDefault(str, 0)+1);
            }
            int j=0;
            while (true){
                if (compareMap.equals(map)){
                    result.add(i+words[0].length()*j);
                }
                String str = s.substring(i+j*words[0].length(), i+(j+1)*words[0].length());
                if (compareMap.get(str) == 1){
                    compareMap.remove(str);
                }else{
                    compareMap.replace(str, compareMap.get(str)-1);
                }
                if (i+(j+words.length+1)*words[0].length()>s.length()){
                    break;
                }
                String next = s.substring(i+(j+words.length)*words[0].length(), i+(j+words.length+1)*words[0].length());
                compareMap.put(next, compareMap.getOrDefault(next, 0)+1);
                j++;
            }
        }
        return result;
    }
}