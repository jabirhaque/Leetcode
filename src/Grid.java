public class Grid {
    public static void main(String[] args){
        System.out.println(minSensors(5,5,1));
    }

    public static int minSensors(int n, int m, int k) {
        return ((int)Math.ceil((double)n/(double)(2*k+1)))*((int)Math.ceil((double)m/(double)(2*k+1)));
    }
}
