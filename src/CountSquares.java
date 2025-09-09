class CountSquares {
    public static void main(String[] args){
        System.out.println(countSquares(new int[][]{{1,0,1,0,1},{1,0,0,1,1},{0,1,0,1,1},{1,0,0,1,1}}));
    }

    public static int countSquares(int[][] matrix) {
        int res = 0;
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (matrix[i][j] == 1){
                    int side = 0;
                    boolean valid = true;
                    while (valid){
                        side++;
                        if (i+side>=matrix.length || j+side>=matrix[i].length) valid = false;
                        if (valid){
                            for (int a=i; a<=i+side && valid; a++){
                                for (int b=j; b<=j+side && valid; b++){
                                    if (matrix[a][b] != 1){
                                        valid = false;
                                    }
                                }
                            }
                        }
                    }
                    for (int a=i; a<i+side; a++){
                        for (int b=j; b<j+side; b++){
                            matrix[a][b] = 0;
                        }
                    }
                    res += side*(side+1)*(2*side+1)/6;
                }
            }
        }
        return res;
    }
}