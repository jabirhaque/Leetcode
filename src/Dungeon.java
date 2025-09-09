class Dungeon {
    public static void main(String[] args){
        System.out.println(calculateMinimumHP(new int[][] {{-2,-3, 3}, {-5, -10, 1}, {10, 30, -5}}));
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        return 1+Math.abs(recursion(dungeon, 0, 0));
    }

    private static int recursion(int[][] dungeon, int i, int j){
        if (i == dungeon.length-1 && j == dungeon[0].length-1){
            return dungeon[i][j];
        }
        return dungeon[i][j]+Math.max(i+1<dungeon.length?recursion(dungeon, i+1, j):Integer.MIN_VALUE, j+1<dungeon.length?recursion(dungeon, i, j+1):Integer.MIN_VALUE);
    }
}