import java.util.Arrays;

class MaximumNumberOfEvents {
    public static void main(String[] args){
        System.out.println(maxEvents(new int[][]{{1,5},{2,5},{1,5},{2,3},{2,3}}));
    }

    public static int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        int lastTaken = 0;
        int count = 0;
        for (int[] event: events){
            if (event[1]>lastTaken){
                count++;
                lastTaken = Math.max(lastTaken+1, event[0]);
            }
        }
        return count;
    }
}