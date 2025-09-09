import java.util.Arrays;

public class Lexigraphical {

    public static void main(String[] args){
        System.out.println(biggerIsGreater("abcd"));
    }

    public static String biggerIsGreater(String w) {
        char[] charArray = w.toCharArray();
        int[] array = new int[charArray.length];
        for (int i=0; i<charArray.length; i++){
            array[i] = charArray[i];
        }
        for (int i=array.length-1; i>=0; i--){
            int j=array.length-1;
            while (j>i && array[j]<array[i]){
                j--;
            }
            if (j==i){
                continue;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            int[] slice = Arrays.copyOfRange(array, i+1, array.length);
            Arrays.sort(slice);
            char[] result = new char[array.length];
            for (int k=0; k<array.length; k++){
                if (k<i+1){
                    result[k] = (char)array[k];
                }else{
                    result[k] = (char)slice[k-i-1];
                }
            }
            String resultString = "";
            for (char c: result){
                resultString += c;
            }
            return resultString;
        }
        return "no answer";
    }
}
