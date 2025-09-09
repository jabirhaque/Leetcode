class Koko {
    public static void main(String[] args){
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n: piles){
            max = Math.max(max, n);
        }
        for (int i=1; i<=max; i++){
            if (satisfies(piles, i, h)){
                return i;
            }
        }
        return -1;
    }

    private static boolean satisfies(int[] piles, int k, int h){
        int[] p = new int[piles.length];
        for (int i=0; i<piles.length; i++){
            p[i] = piles[i];
        }
        int count = 0;
        int index = 0;
        while (p[p.length-1]!=0){
            p[index] = p[index]>k?p[index]-k:0;
            index += p[index]==0?1:0;
            count++;
        }
        return count<=h;
    }
}