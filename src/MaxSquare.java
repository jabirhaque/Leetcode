public class MaxSquare {
    public static void main(String[] args){
        System.out.println(maxSideLength(new int[][] {{0}}, 0));
    }

    public static int maxSideLength(int[][] mat, int threshold) {
        int[][] prefix = new int[mat.length][mat[0].length+1];
        for (int i=0; i<mat.length; i++){
            for (int j=1; j<prefix[i].length; j++){
                prefix[i][j] = prefix[i][j-1]+mat[i][j-1];
            }
        }
        int max = 0;
        for (int i=0; i<prefix.length; i++){
            for (int j=0; j<prefix[i].length; j++){
                int length = 0;
                int sum = 0;
                while (sum<=threshold && i+length-1<prefix.length && j+length<prefix[i].length){
                    max = Math.max(max, length);
                    length++;
                    sum = 0;
                    for (int a = i; a<i+length && a<prefix.length; a++){
                        sum += (j+length)<prefix[a].length?prefix[a][j+length]-prefix[a][j]:0;
                    }
                }
            }
        }
        return max;
    }
}