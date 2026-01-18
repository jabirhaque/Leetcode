class Stone {
    public static void main(String[] args){
        winnerSquareGame(2);
    }

    public static boolean winnerSquareGame(int n) {
        return win(n, true);
    }

    private static boolean win(int n, boolean alice){
        if (n == 0) return false;
        for (int i=1; i<=Math.sqrt(n); i++){
            if (!win(n-i*i, !alice)) return true;
        }
        return false;
    }
}