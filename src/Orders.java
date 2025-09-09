public class Orders {
    public static void main(String[] args){
        System.out.println(result(new int[]{1,6,3,2,5,8,7,5,9,1}));
    }
    private static int result(int[] orders){
        int result = 0;
        for (int i=0; i<orders.length-2; i++){
            int max = orders[i+1];
            int j=i+2;
            int count = 0;
            while (j<orders.length){
                if (Math.min(orders[i], orders[j])>max){
                    count++;
                }
                max = Math.max(max, orders[j]);
                j++;
            }
            result+=count;
        }
        return result;
    }
}
