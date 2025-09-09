class Grumpy {
    public static void main(String[] args){
        maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3);
    }
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int[] grumpyCopy = new int[grumpy.length];
        for (int j=0; j<grumpy.length; j++){
            if (j>=0 && j<minutes){
                grumpyCopy[j] = 0;
            }else{
                grumpyCopy[j] = grumpy[j];
            }
        }
        int max = satisfied(customers, grumpyCopy);
        for (int i=1; i<=customers.length-minutes; i++){
            grumpyCopy[i-1] = grumpy[i-1];
            grumpyCopy[i+minutes-1] = 0;
            max = Math.max(max, satisfied(customers, grumpyCopy));
        }
        return max;
    }

    private static int satisfied(int[] customers, int[] grumpy){
        int sum = 0;
        for (int i=0; i<customers.length; i++){
            if (grumpy[i] == 0){
                sum += customers[i];
            }
        }
        return sum;
    }
}