class Gas {
    public static void main(String[] args){
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i=0; i<gas.length; i++) gas[i] -= cost[i];
        int i=0;
        while (i<gas.length){
            int j=i+1;
            int sum = gas[i];
            while (j<i+gas.length && sum >= 0){
                j++;
                sum += gas[j%gas.length];
            }
            if (j == i+gas.length && sum>=0) return i;
            i = j;
        }
        return -1;
    }
}