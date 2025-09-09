import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Diagonal {
    public static void main(String[] args){
        System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}})));
    }
    public static int[] findDiagonalOrder(int[][] mat) {
        List<List<Integer>> unordered = new ArrayList<>();
        int count = 0;
        int i=0;
        while (count<mat.length*mat[0].length){
            List<Integer> list = new ArrayList<>();
            int first = Math.min(i, mat.length-1);
            int last = i-Math.min(i, mat[0].length-1);
            while (first>=last){
                list.add(mat[first][i-first]);
                count++;
                first--;
            }
            unordered.add(list);
            i++;
        }
        List<Integer> result = new ArrayList<>();
        boolean forward = true;
        for (List<Integer> list: unordered){
            if (forward){
                for (i=0; i<list.size(); i++){
                    result.add(list.get(i));
                }
            }else{
                for (i=list.size()-1; i>=0; i--){
                    result.add(list.get(i));
                }
            }
            forward = !forward;
        }
        int[] res = new int[result.size()];
        for (i=0; i<res.length; i++){
            res[i] = result.get(i);
        }
        return res;
    }
}