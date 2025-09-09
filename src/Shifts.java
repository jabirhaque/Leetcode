import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Shifts {
    public static void main(String[] args){
        System.out.println(shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));
    }

    public static String shiftingLetters(String s, int[] shifts) {
        long[] newShifts = new long[shifts.length];
        for (int i=0; i<shifts.length; i++){
            newShifts[i] = shifts[i];
        }
        Map<Long, Character> map = new HashMap<>();
        for (int i=0; i<26; i++){
            map.put((long)i, (char)('a'+i));
        }
        for (int i=newShifts.length-2; i>=0; i--){
            newShifts[i] += newShifts[i+1];
        }
        List<Character> characters = new ArrayList<>();
        for (int i=0; i<newShifts.length; i++){
            characters.add(map.get(((s.charAt(i)-'a') + newShifts[i]%26)%26));
        }
        return concatChars(characters);
    }

    private static String concatChars(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}