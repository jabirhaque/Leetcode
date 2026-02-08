import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SummaryRangesClass {

    List<Integer> list;

    public SummaryRangesClass() {
        list = new ArrayList<>();
    }

    public void addNum(int value) {
        list.add(value);
    }

    public int[][] getIntervals() {
        Collections.sort(list);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i<list.size()){
            int start = list.get(i);
            int j = i;
            while (j < list.size() && (j == i || list.get(j) <= list.get(j-1) + 1)) j++;
            int end = list.get(j-1);
            result.add(List.of(start, end));
            i=j;
        }
        int[][] res = new int[result.size()][2];
        for (i = 0; i<res.length; i++){
            res[i][0] = result.get(i).get(0);
            res[i][1] = result.get(i).get(1);
        }
        return res;
    }
}

class SummaryRanges{
    public static void main(String[] args){
        SummaryRangesClass summaryRanges = new SummaryRangesClass();
        summaryRanges.addNum(1);      // arr = [1]
        summaryRanges.getIntervals(); // return [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
    }
}