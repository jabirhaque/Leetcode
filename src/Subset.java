import java.util.*;

public class Subset {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(List.of(1,7,2,4));
        System.out.println(nonDivisibleSubset(3, list));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        for (int i=0; i<s.size(); i++){
            s.set(i, s.get(i)%k);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<s.size(); i++){
            if (map.containsKey(s.get(i))){
                map.replace(s.get(i), map.get(s.get(i))+1);
            }else{
                map.put(s.get(i), 1);
            }
        }
        int count = 0;
        Set<Integer> current = new HashSet<>();
        for (int c: map.keySet()){
            int competitor = k-c;
            if (c==0 || c==competitor){
                count+=1;
                continue;
            }
            if (current.contains(c) || current.contains(competitor)){
                continue;
            }
            if (map.containsKey(competitor)){
                if (map.get(c)>map.get(competitor)){
                    count+=map.get(c);
                    current.add(c);
                }else{
                    count+=map.get(competitor);
                    current.add(competitor);
                }
            }else{
                count+=map.get(c);
                current.add(c);
            }
        }
        return count;
    }

}
