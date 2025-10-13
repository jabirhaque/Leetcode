class BrokenCalc {
    public static void main(String[] args){
        System.out.println(brokenCalc(1, 1000000));
    }

    public static int brokenCalc(int startValue, int target) {
        int count = 0;
        int i = startValue;
        while (i!=target){
            int first = 2*i;
            int second = 2*(i-1);
            if (Math.abs(target-first) > Math.abs(target-second)){
                i--;
            }else{
                i*=2;
            }
            System.out.println(i);
            count++;
        }
        return count;
    }
}