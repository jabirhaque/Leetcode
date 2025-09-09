public class Paritions {

    public static void main(String[] args){
        System.out.println(partitions(new int[]{10, 4, -8, 7}));
    }

    public static int partitions(int[] nums){
        int[] prefix = new int[nums.length+1];
        for (int i=1; i<prefix.length; i++){
            prefix[i] = nums[i-1]+prefix[i-1];
        }
        int count = 0;
        for (int i=1; i<prefix.length-1; i++){
            if (prefix[i]>prefix[prefix.length-1]-prefix[i]){
                count++;
            }
        }
        return count;
    }

}
