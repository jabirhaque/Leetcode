class Points {
    public static void main(String[] args){
        System.out.println(maxPoints(new int[][]{{-6, -1}, {3, 1}, {12, 3}}));
    }

    public static int maxPoints(int[][] points) {
        double EPSILON = 1e-9;
        int max = 1;
        for (int i=0; i<points.length; i++){
            for (int j=0; j<points.length; j++){
                if (i == j) continue;
                double m = (double)(points[j][1]-points[i][1])/(double)(points[j][0]-points[i][0]);
                double c = points[i][1]-m*points[i][0];
                int count = 0;
                if (m == Double.POSITIVE_INFINITY || m == Double.NEGATIVE_INFINITY){
                    for (int k=0; k<points.length; k++) if (points[k][0] == points[i][0]) count++;
                }
                else {
                    for (int k=0; k<points.length; k++) if (Math.abs(points[k][1] - (m*points[k][0]+c)) < EPSILON) count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}