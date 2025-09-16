import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public static void main(String[] args){
        int res = expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});
        System.out.println(res);
    }

    public static int expressiveWords(String s, String[] words) {
        List<Character> characters = new ArrayList<>();
        List<Integer> frequencies = new ArrayList<>();
        for (int i=0; i<s.length(); i++){
            if (i == 0 || s.charAt(i) != s.charAt(i-1)){
                characters.add(s.charAt(i));
                frequencies.add(1);
            }else{
                frequencies.set(frequencies.size()-1, frequencies.get(frequencies.size()-1)+1);
            }
        }
        int count = 0;
        for (String word: words){
            List<Character> chars = new ArrayList<>();
            List<Integer> freqs = new ArrayList<>();
            for (int i=0; i<word.length(); i++){
                if (i == 0 || word.charAt(i) != word.charAt(i-1)){
                    chars.add(word.charAt(i));
                    freqs.add(1);
                }else{
                    freqs.set(freqs.size()-1, freqs.get(freqs.size()-1)+1);
                }
            }
            if (!characters.equals(chars)) continue;
            boolean valid = true;
            for (int i=0; i<freqs.size() && valid; i++) if (freqs.get(i) > frequencies.get(i) || freqs.get(i) < frequencies.get(i) && frequencies.get(i) < 3) valid = false;
            if (valid) count++;
        }
        return count;
    }
}
