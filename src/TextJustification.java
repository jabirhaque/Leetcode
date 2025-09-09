import java.util.ArrayList;
import java.util.List;

class TextJustification {
    public static void main(String[] args){
        System.out.println(fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i=0;
        while (i<words.length){
            int j=i;
            int chars = 0;
            while (j<words.length && chars+(j-i-1)<=maxWidth){
                chars+=words[j].length();
                j++;
            }
            if (chars+(j-i-1)>maxWidth){
                j--;
                chars-=words[j].length();
            }
            String str = "";
            if (j == words.length){
                for (int k=i; k<j; k++){
                    str+=words[k];
                    if (k!=j-1){
                        str+=" ";
                    }else{
                        int count = maxWidth-str.length();
                        for (int l=0; l<count; l++){
                            str+=" ";
                        }
                    }
                }
            }else{
                int remainingSpaces = maxWidth-chars;
                if (j-i==1){
                    str+=words[i];
                    for (int a=0; a<remainingSpaces; a++){
                        str+=" ";
                    }
                }else{
                    int[] spaces = new int[j-i];
                    for (int a=0; a<spaces.length-1; a++){
                        spaces[a] = 1;
                        remainingSpaces--;
                    }
                    int a=0;
                    while (remainingSpaces>0){
                        if (a%spaces.length == spaces.length-1){
                            a++;
                            continue;
                        }
                        spaces[a%spaces.length] += 1;
                        remainingSpaces--;
                        a++;
                    }
                    for (int b=i; b<j; b++){
                        str+=words[b];
                        for (int c=0; c<spaces[b-i]; c++){
                            str+=" ";
                        }
                    }
                }
            }
            result.add(str);
            i=j;
        }
        return result;
    }
}