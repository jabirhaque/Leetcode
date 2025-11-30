class BestSightseeing {
    public static void main(String[] args){
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int best = values[0];
        for (int i=1; i<values.length; i++){
            max = Math.max(max, values[i]-i+best);
            best = Math.max(best, values[i]+i);
        }
        return max;
    }
}