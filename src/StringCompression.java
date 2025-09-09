import java.util.ArrayList;
import java.util.List;

class StringCompression {
    public static void main(String[] args){
        char[] chars = new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
        System.out.println(chars);
    }


    public static int compress(char[] chars) {
        List<Character> characters = new ArrayList<>();
        int i=0;
        while (i<chars.length){
            int j=i;
            while (j<chars.length && chars[j] == chars[i]){
                j++;
            }
            int count = j-i;
            characters.add(chars[i]);
            if (count > 1){
                char[] num = String.valueOf(count).toCharArray();
                for (char dig: num){
                    characters.add(dig);
                }
            }
            i=j;
        }
        char[] result = new char[characters.size()];
        for (i=0; i<characters.size(); i++){
            result[i] = characters.get(i);
        }
        System.arraycopy(result, 0, chars, 0, result.length);
        return result.length;
    }
}