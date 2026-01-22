import java.util.Arrays;

class Capa {
    public static void main(String[] args){
        System.out.println(maxCapacity(new int[]{4,6}, new int[]{5,3}, 3));
    }

    public static int maxCapacity(int[] costs, int[] capacity, int budget) {
        Integer[] order = new Integer[costs.length];
        for (int i=0; i<costs.length; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> costs[a] == costs[b] ? capacity[a]-capacity[b] : costs[a]-costs[b]);
        int[] sortedCosts = new int[costs.length];
        int[] sortedCapacity = new int[capacity.length];
        for (int i=0; i<costs.length; i++){
            sortedCosts[i] = costs[order[i]];
            sortedCapacity[i] = capacity[order[i]];
        }

        int[] prefix = new int[capacity.length];
        prefix[0] = sortedCapacity[0];
        for (int i=1; i<prefix.length; i++) prefix[i] = Math.max(prefix[i-1], sortedCapacity[i]);
        int best = 0;
        for (int i=0; i<costs.length; i++){
            if (sortedCosts[i] >= budget) continue;
            int total = sortedCapacity[i];
            int target = budget-sortedCosts[i];

            int l=0;
            int r=i-1;
            int max = -1;
            while (l<r){
                int m = (l+r)/2;
                if (sortedCosts[m] < target){
                    max = m;
                    l=m+1;
                }else{
                    r=m;
                }
            }
            if (l < i && sortedCosts[l] < target) max = l;

            if (max > -1) total += prefix[max];
            best = Math.max(best, total);
        }
        return best;
    }
}