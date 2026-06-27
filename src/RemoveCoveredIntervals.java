import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveCoveredIntervals {
    public static void main(String[] args){
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(new int[][] {{1, 4}, {3, 6}, {2, 8}}));
    }

    public int removeCoveredIntervals(int[][] intervals){
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        int i = 0;
        while (i<intervals.length){
            int j = i+1;
            while (j<intervals.length && intervals[j][1]<=intervals[i][1]){
                count++;
                j++;
            }
            i = j;
        }
        return count;
    }
}
