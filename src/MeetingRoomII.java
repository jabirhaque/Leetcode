import java.util.ArrayList;
import java.util.List;

class Interval {
    public int start, end;
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MeetingRoomII {
    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 50));
        intervals.add(new Interval(10, 60));
        intervals.add(new Interval(60, 110));
        intervals.add(new Interval(70, 120));
        intervals.add(new Interval(20, 70));
        intervals.add(new Interval(30, 80));
        intervals.add(new Interval(40, 90));
        intervals.add(new Interval(50, 100));
        intervals.add(new Interval(80, 130));
        intervals.add(new Interval(90, 140));
        intervals.add(new Interval(100, 150));
        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) return 0;
        List<List<Interval>> levels = new ArrayList<>();
        levels.add(new ArrayList<>());
        for (Interval interval: intervals){
            for (int i=levels.size()-1; i>=0; i--){
                for (Interval compare: levels.get(i)){
                    if (interval.start>=compare.start && interval.start<compare.end || compare.start>=interval.start && compare.start<interval.end){
                        Interval insert = new Interval(Math.max(interval.start, compare.start), Math.min(interval.end, compare.end));
                        if (i == levels.size()-1){
                            List<Interval> newLevel = new ArrayList<>();
                            newLevel.add(insert);
                            levels.add(newLevel);
                        }else{
                            levels.get(i+1).add(insert);
                        }
                    }
                }
            }
            levels.get(0).add(interval);
        }
        return levels.size();
    }
}
