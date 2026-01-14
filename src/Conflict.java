import java.util.Arrays;

class Conflict {
    public static void main(String[] args){
        System.out.println(bestTeamScore(new int[]{1,3,7,3,2,4,10,7,5}, new int[]{4,5,2,1,1,2,4,1,4}));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        Integer[] order = new Integer[ages.length];
        for (int i=0; i<order.length; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> ages[a] == ages[b] ? scores[a] - scores[b] : ages[a] - ages[b]);
        int[] sortedScores = new int[scores.length];
        for (int i=0; i<sortedScores.length; i++) sortedScores[i] = scores[order[i]];
        Arrays.sort(ages);
        return dp(sortedScores, ages, 0, -1);
    }

    private static int dp(int[] scores, int[] ages, int i, int j){
        if (i == scores.length) return 0;
        int max = dp(scores, ages, i+1, j);
        if (j == -1 || ages[i] == ages[j] || scores[i] >= scores[j]) max = Math.max(max, scores[i]+dp(scores, ages, i+1, i));
        return max;
    }
}