class MatrixSum {
    public static void main(String[] args){
        System.out.println(matrixBlockSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 1));
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] prefix = new int[mat.length][mat[0].length];
        for (int i=0; i<mat.length; i++){
            int sum = 0;
            for (int c=-k; c<=k; c++){
                sum += (c>=0 && c<mat[i].length)?mat[i][c]:0;
            }
            for (int j=0; j<mat[i].length; j++){
                prefix[i][j] = sum;
                sum -= (j-k>=0)?mat[i][j-k]:0;
                sum += (j+k+1<mat[i].length)?mat[i][j+k+1]:0;
            }
        }
        int[][] res = new int[mat.length][mat[0].length];
        for (int j=0; j<mat[0].length; j++){
            int sum = 0;
            for (int r=-k; r<=k; r++){
                sum += (r>=0 && r<mat.length)?prefix[r][j]:0;
            }
            for (int i=0; i<mat.length; i++){
                res[i][j] = sum;
                sum -= (i-k>=0)?prefix[i-k][j]:0;
                sum += (i+k+1<mat.length)?prefix[i+k+1][j]:0;
            }
        }
        return res;
    }
}