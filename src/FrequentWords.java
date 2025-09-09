import java.util.*;

class FrequentWords {
    public static void main(String[] args){
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        Map<Integer, List<String>> freq = new HashMap<>();
        for (String word: map.keySet()){
            if (freq.containsKey(map.get(word))){
                freq.get(map.get(word)).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                freq.put(map.get(word), list);
            }
        }
        List<Integer> freqList = new ArrayList<>(freq.keySet());
        Collections.sort(freqList, Collections.reverseOrder());
        List<String> result = new ArrayList<>();
        int listPointer = 0;
        while (result.size()<k){
            List<String> list = freq.get(freqList.get(listPointer));
            Collections.sort(list);
            for (int i=0; i<list.size()&&result.size()<k; i++){
                result.add(list.get(i));
            }
            listPointer++;
        }
        return result;
    }
}