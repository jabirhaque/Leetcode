class FreeDay {
    public static void main(String[] args){
        System.out.println(countDays(10, new int[][]{{5,7}, {1,3}, {9,10}}));
    }

    public static int countDays(int days, int[][] meetings) {
        int[] difference = new int[days];
        for (int[] meeting: meetings){
            difference[meeting[0]-1]++;
            if (meeting[1]<days) difference[meeting[1]]--;
        }
        int count = difference[0];
        for (int i=1; i<days; i++){
            difference[i] += difference[i-1];
            if (difference[i] == 0) count++;
        }
        return count;
    }
}