import java.util.ArrayList;
import java.util.List;

class MinSwap {

    public static void main(String[] args){
        System.out.println(minSwaps(new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}}));
    }

    public static int minSwaps(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<grid.length; i++){
            String str = "";
            for (int j: grid[i]) str+=j;
            list.add(Integer.parseInt(str, 2));
        }
        int count = 0;
        for (int i=0; i<list.size(); i++){
            int res = count(list, i);
            if (res == -1) return -1;
            count+=res;
        }
        return count;
    }

    private static int count(List<Integer> list, int i){
        int mod = (int)Math.pow(2, list.size()-i-1);
        int closest = Integer.MAX_VALUE;
        for (int j=i; j<list.size(); j++){
            if (list.get(j)%mod == 0 && Math.abs(j-i) < Math.abs(closest-i)) closest = j;
        }
        if (closest == Integer.MAX_VALUE) return -1;
        int res = list.get(closest);
        list.remove(closest);
        list.add(i, res);
        return Math.abs(closest-i);
    }
}