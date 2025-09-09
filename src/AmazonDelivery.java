public class AmazonDelivery {
    public static void main(String[] args){
        System.out.println(shipments(new int[] {1,2,3,2,6,3}));
        System.out.println(shipments(new int[] {8,5,4,7,2}));
        System.out.println(shipments(new int[] {4,3,6,5,3,4,7,1}));
    }

    public static int shipments(int[] weights){
        int j=0;
        int count = 0;
        int max = weights[0];
        while (j<weights.length){
            if (weights[j] == max){
                j++;
                if (j<weights.length){
                    max = Math.max(max, weights[j]);
                }
            }else{
                count++;
                j++;
                if (j<weights.length){
                    max = weights[j];
                }
            }
        }
        return count;
    }
}
