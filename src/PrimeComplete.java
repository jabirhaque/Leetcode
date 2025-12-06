class PrimeComplete {
    public static void main(String[] args){
        System.out.println(completePrime(1));
    }

    public static boolean completePrime(int num) {
        String str = String.valueOf(num);
        String prefix = "";
        String suffix = "";
        for (char c: str.toCharArray()){
            prefix+=c;
            if (!prime(Integer.valueOf(prefix))) return false;
        }
        for (int i=str.length()-1; i>=0; i--){
            suffix = str.charAt(i) + suffix;
            if (!prime(Integer.valueOf(suffix))) return false;
        }
        return true;
    }

    private static boolean prime(int num){
        if (num == 1) return false;
        for (int i=2; i<Math.sqrt(num)+1 && i<num; i++){
            if (num%i == 0) return false;
        }
        return true;
    }
}