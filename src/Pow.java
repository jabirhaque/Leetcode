class Pow {
    public static void main(String[] args){
        Pow pow = new Pow();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(pow.myPow(2.00000, -2));
    }

    public double myPow(double x, int n) {
        return pow(x, n);
    }

    public double pow(double x, long n) {
        if (n<0){
            return (double)1/pow(x, n);
        }
        double current = 1;
        if (x == 1) return 1;
        for (int i=0; i<n; i++){
            current*=x;
        }
        return current;
    }
}