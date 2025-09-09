import java.util.*;

class StraightHand {
    public static void main(String[] args){
        System.out.println(isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        List<Integer> list = new ArrayList<>();
        for (int card: hand){
            list.add(card);
        }
        while (list.size()!=0){
            int lowest = list.get(0);
            int count = 0;
            int target = lowest;
            Set<Integer> remove = new HashSet<>();
            for (int i=0; i<list.size() && count<groupSize; i++){
                if (list.get(i)==target){
                    remove.add(i);
                    target++;
                    count++;
                }
            }
            if (count!=groupSize){
                return false;
            }
            List<Integer> newList = new ArrayList<>();
            for (int i=0; i<list.size(); i++){
                if (!remove.contains(i)){
                    newList.add(list.get(i));
                }
            }
            list = newList;
        }
        return true;
    }
}