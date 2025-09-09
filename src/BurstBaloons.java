import java.util.ArrayList;
import java.util.List;

class BurstBaloons {
    public static void main(String[] args){
        System.out.println(maxCoins(new int[]{3,1,5,8}));
    }

    public static int maxCoins(int[] nums) {
        List<Integer> baloons = new ArrayList<>();
        for (int n: nums){
            baloons.add(n);
        }
        return recursion(baloons);
    }

    private static int recursion(List<Integer> baloons){
        int max = 0;
        for (int i=0; i<baloons.size(); i++){
            int pop = (i==0?1:baloons.get(i-1))*baloons.get(i)*(i==baloons.size()-1?1:baloons.get(i+1));
            List<Integer> newBaloons = new ArrayList<>();
            for (int j=0; j<baloons.size(); j++){
                if (j!=i){
                    newBaloons.add(baloons.get(j));
                }
            }
            max = Math.max(max, pop+recursion(newBaloons));
        }
        return max;
    }
}