import java.util.*;

public class ThreeConditions {
    public static void main(String[] args){
        System.out.println(minCharacters("a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

    public static int minCharacters(String a, String b) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for (int c: a.toCharArray()){
            aList.add(c);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (int c: b.toCharArray()){
            bList.add(c);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        Collections.sort(aList);
        Collections.sort(bList);
        int max = 0;
        for (int i: map.keySet()){
            max = Math.max(max, map.get(i));
        }
        return Math.min(a.length()+b.length()-max, Math.min(min(aList, bList), min(bList, aList)));
    }

    private static int min(List<Integer> a, List<Integer> b){
        //assume both are sorted and we want all of a < all of b
        //go through each minimum
        int res = Integer.MAX_VALUE;
        for (int i=0; i<a.size(); i++){
            if (i<a.size()-1 && a.get(i)==a.get(i+1) || a.get(i) == 'z'){
                continue;
            }
            int target = a.get(i); // everyone in b must be greater than to target
            //binary search until we find the leftmost element in b that satisfies this - if satisfies go left else go right
            int l=0;
            int r=b.size()-1;
            int min = b.size();
            while (l<r){
                int m = (l+r)/2;
                if (b.get(m)>target){
                    r = m;
                    min = Math.min(min, m);
                }else{
                    l = m+1;
                }
            }
            if (b.get(l)>target){
                min = Math.min(min, l);
            }
            res = Math.min(res, min+a.size()-i-1);
        }
        return res;
    }

}
