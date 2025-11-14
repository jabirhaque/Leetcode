import java.util.ArrayList;
import java.util.List;

class FibString {
    public static void main(String[] args){
        System.out.println(splitIntoFibonacci("1101111"));
    }

    public static List<Integer> splitIntoFibonacci(String num) {
        List<Integer> indexes = backtrack(num, new ArrayList<>(), 0);
        if (indexes.isEmpty()) return indexes;
        List<Integer> res = new ArrayList<>();
        res.add(Integer.valueOf(num.substring(0, indexes.get(0)+1)));
        for (int i=1; i<indexes.size(); i++){
            res.add(Integer.valueOf(num.substring(indexes.get(i-1)+1, indexes.get(i)+1)));
        }
        return res;
    }

    private static List<Integer> backtrack(String num, List<Integer> current, int i){
        if (i == num.length()) return current;
        if (current.size() < 2){
            if (num.charAt(i) == '0'){
                current.add(i);
                List<Integer> res = backtrack(num, current, i+1);
                if (!res.isEmpty()) return res;
                current.remove(current.size()-1);
                return new ArrayList<>();
            }
            for (int j=i; j<num.length()-(2-current.size()) && Long.valueOf(num.substring(i, j+1))<Integer.MAX_VALUE; j++){
                current.add(j);
                List<Integer> res = backtrack(num, current, j+1);
                if (!res.isEmpty()) return res;
                current.remove(current.size()-1);
            }
            return new ArrayList<>();
        }
        int first = Integer.valueOf(num.substring((current.size() == 2?0:current.get(current.size()-3)+1), current.get(current.size()-2)+1));
        int second = Integer.valueOf(num.substring(current.get(current.size()-2)+1, current.get(current.size()-1)+1));
        long target = first + second;
        if (target>Integer.MAX_VALUE) return new ArrayList<>();
        if (num.charAt(i) == '0'){
            if (target != 0) return new ArrayList<>();
            current.add(i);
            List<Integer> res = backtrack(num, current, i+1);
            if (!res.isEmpty()) return res;
            current.remove(current.size()-1);
            return new ArrayList<>();
        }
        String str = "";
        for (int j=i; j<num.length() && Long.valueOf(num.substring(i, j+1))<Integer.MAX_VALUE; j++){
            str+=num.charAt(j);
            if (Integer.valueOf(str) == target){
                current.add(j);
                List<Integer> res = backtrack(num, current, j+1);
                if (!res.isEmpty()) return res;
                current.remove(current.size()-1);
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}