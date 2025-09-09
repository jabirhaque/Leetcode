import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Time {
    public static void main(String[] args){
        System.out.println(findMinDifference(List.of("23:59", "00:00")));
    }

    public static int findMinDifference(List<String> timePoints) {
        List<Integer> timeInts = new ArrayList<>();
        for (String time: timePoints){
            timeInts.add(Integer.valueOf(String.valueOf(time.charAt(0))+String.valueOf(time.charAt(1))+String.valueOf(time.charAt(3))+String.valueOf(time.charAt(4))));
        }
        Collections.sort(timeInts);
        int min = Integer.MAX_VALUE;
        for (int i=0; i<timeInts.size(); i++){
            int absDiff = 60*(timeInts.get((i+1)%timeInts.size())/100-timeInts.get(i)/100)+(timeInts.get((i+1)%timeInts.size())%100-timeInts.get(i)%100);
            min = Math.min(min, absDiff);
            min = Math.min(min, 1440-absDiff);
        }
        return min;
    }
}