class Squares {
    public static void main(String[] args){
        boolean result = judgeSquareSum(2147483600);
        System.out.println(result);
    }

    public static boolean judgeSquareSum(int c) {
        long[] squares = new long[(int)Math.sqrt(c)+1];
        for (int i=0; i<squares.length; i++){
            squares[i] = i*i;
        }
        int l = 0;
        int r = squares.length-1;
        while (l<=r){
            if (squares[l]+squares[r] == c){
                return true;
            }
            if (squares[l]+squares[r] > c){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
}