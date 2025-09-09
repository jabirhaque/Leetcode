import java.util.ArrayList;
import java.util.List;

class RemoveComments {
    public static void main(String[] args){
        //System.out.println(removeComments(new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"}));
        System.out.println(removeComments(new String[]{"a//*b//*c","blank","d/*/e*//f"}));
    }

    public static List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String line: source){
            list.add(line);
        }
        boolean block = false;
        boolean append = false;
        for (int i=0; i<list.size(); i++){
            boolean comment = false;
            for (int j=0; j<list.get(i).length()-1; j++){
                if (block && list.get(i).charAt(j) == '*' && list.get(i).charAt(j+1) == '/'){
                    if (j+2 != list.get(i).length()){
                        if (append){
                            result.set(result.size()-1, result.get(result.size()-1)+list.get(i).substring(j+2));
                            append = false;
                        }else{
                            result.add(list.get(i).substring(j+2));
                        }
                    }
                    block = false;
                    comment = true;
                }
                if (!block && list.get(i).charAt(j) == '/'){
                    if (list.get(i).charAt(j+1) == '/'){
                        if (j != 0){
                            result.add(list.get(i).substring(0, j));
                        }
                        comment = true;
                        break;
                    }
                    if (list.get(i).charAt(j+1) == '*'){
                        if (j != 0){
                            result.add(list.get(i).substring(0, j));
                            append = true;
                        }
                        comment = true;
                        block = true;
                        j++;
                    }
                }
            }
            if (!block && !comment){
                result.add(list.get(i));
            }
        }
        return result;
    }
}