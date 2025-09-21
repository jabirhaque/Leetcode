import java.util.Arrays;

class Matrix01 {
    public static void main(String[] args){
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));
    }

    public static int[][] updateMatrix(int[][] mat) {
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                if (mat[i][j] != 0) mat[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i=0; i<mat.length; i++){
            for (int j=0; j<mat[i].length; j++){
                if (mat[i][j] == 0){
                    dfs(mat, i-1, j, 1);
                    dfs(mat, i+1, j, 1);
                    dfs(mat, i, j-1, 1);
                    dfs(mat, i, j+1, 1);
                }
            }
        }
        return mat;
    }

    private static int[][] dfs(int[][] mat, int i, int j, int n){
        if (i<0 || i>=mat.length || j<0 || j>=mat[0].length || n >= mat[i][j]) return mat;
        mat[i][j] = n;
        dfs(mat, i-1, j, n+1);
        dfs(mat, i+1, j, n+1);
        dfs(mat, i, j-1, n+1);
        dfs(mat, i, j+1, n+1);
        return mat;
    }
}