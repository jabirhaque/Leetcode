import java.util.Arrays;
import java.util.List;

class MaxRect {
    public static void main(String[] args){
        System.out.println(maximalRectangle(new char[][]
                        {
                                {'1', '0', '1', '0', '0'},
                                {'1', '0', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'},
                                {'1', '0', '0', '1', '0'}
                        }
                ));
    }

    public static int maximalRectangle(char[][] matrix) {
        int[][] length = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            length[i][matrix[0].length-1] = matrix[i][matrix[0].length-1]-'0';
            for (int j=matrix[0].length-2; j>=0; j--){
                if (matrix[i][j] == '0') length[i][j] = 0;
                else length[i][j] = 1+length[i][j+1];
            }
        }
        int[][] width = new int[matrix.length][matrix[0].length];
        for (int j=0; j<matrix[0].length; j++){
            width[matrix.length-1][j] = matrix[matrix.length-1][j]-'0';
            for (int i=matrix.length-2; i>=0; i--){
                if (matrix[i][j] == '0') width[i][j] = 0;
                else width[i][j] = 1+width[i+1][j];
            }
        }
        int[][] dpLength = new int[matrix.length][matrix[0].length];
        int[][] dpWidth = new int[matrix.length][matrix[0].length];
        for (int[] arr: dpLength) Arrays.fill(arr, -1);
        for (int[] arr: dpWidth) Arrays.fill(arr, -1);
        int max = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[0].length; j++){
                List<Integer> res = dimentions(length, width, i, j, dpLength, dpWidth);
                max = Math.max(max, res.get(0)*res.get(1));
            }
        }
        return max;
    }

    private static List<Integer> dimentions(int[][] length, int[][] width, int i, int j, int[][] dpLength, int[][] dpWidth){
        if (dpLength[i][j] > -1) return List.of(dpLength[i][j], dpWidth[i][j]);
        if (length[i][j] == 0) return List.of(0, 0);
        int len = length[i][j];
        int wid = width[i][j];
        if (i+1 == length.length || j+1 == length[0].length) return List.of(len, wid);
        List<Integer> next = dimentions(length, width, i+1, j+1, dpLength, dpWidth);
        if (len != 1) len = Math.min(len, next.get(0)+1);
        if (len != 1) wid = Math.min(wid, next.get(1)+1);
        dpLength[i][j] = len;
        dpWidth[i][j] = wid;
        return List.of(len, wid);
    }
}