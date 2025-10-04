import java.util.Arrays;

class BaloonArrows {
    public static void main(String[] args){
        System.out.println(findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1]-b[1]);
        int count = 0;
        long lastEnd = Long.MIN_VALUE;
        for (int[] interval: points){
            if (interval[0] > lastEnd){
                lastEnd = interval[1];
                count++;
            }
        }
        return count;
    }
}