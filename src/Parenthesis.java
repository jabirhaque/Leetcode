import java.util.ArrayList;
import java.util.List;

class Parenthesis {
    public static void main(String[] args){
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        int symbols = 0;
        for (char c: expression.toCharArray()){
            if (c == '+' || c == '-' || c == '*'){
                symbols++;
            }
        }
        if (symbols == 0){
            return List.of(Integer.valueOf(expression));
        }
        List<Integer> results = new ArrayList<>();
        for (int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*'){
                boolean add = c=='+';
                boolean subtract = c=='-';
                List<Integer> first = diffWaysToCompute(expression.substring(0, i));
                List<Integer> second = diffWaysToCompute(expression.substring(i+1));
                for (int f: first){
                    for (int s: second){
                        int res = add ? f+s: (subtract ? f-s: f*s);
                        results.add(res);
                    }
                }
            }
        }
        return results;
    }
}