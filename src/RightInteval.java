import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RightInteval {
    public static void main(String[] args){
        System.out.println(Arrays.toString(findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}})));
    }
    public static int[] findRightInterval(int[][] intervals) {
        List<Integer> indexes = new ArrayList<>();
        for (int i=0; i<intervals.length; i++){
            indexes.add(i);
        }
        Collections.sort(indexes, (a, b)->intervals[a][0]-intervals[b][0]);
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int[] res = new int[intervals.length];
        for (int i=0; i<intervals.length; i++){
            int target = intervals[i][1];
            int l=0;
            int r=intervals.length-1;
            int min = intervals.length;
            while (l<r){
                int m = (l+r)/2;
                if (intervals[m][0]>=target){
                    r = m;
                    min = Math.min(min, m);
                }else{
                    l = m+1;
                }
            }
            if (intervals[l][0]>=target){
                min = Math.min(min, l);
            }
            res[indexes.get(i)] = min == intervals.length?-1:indexes.get(min);
        }
        return res;
    }
}