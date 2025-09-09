import java.util.HashMap;
import java.util.Map;

public class LeapGame {

    public static void main(String[] args){
        System.out.println(canWin(3, new int[]{0,0,0,0,0}));
        System.out.println(canWin(5, new int[]{0,0,0,1,1,1}));
        System.out.println(canWin(3, new int[]{0,0,1,1,1,0}));
        System.out.println(canWin(1, new int[]{0,1,0}));
    }

    public static boolean canWin(int leap, int[] game) {
        int position = 0;
        return recursion(leap, game, position, new HashMap<>());
    }

    private static boolean recursion(int leap, int[] game, int position, Map<Integer, Integer> map){
        if (map.containsKey(position)){
            return false;
        }else{
            map.put(position, 1);
        }
        if (position>=game.length){
            return true;
        } // you've reached a position beyond the game, you win
        if (position-1>=0 && game[position-1] == 0 && recursion(leap, game, position-1, map)){
            return true;
        } // a position back is free and upon visiting it, you've found a path to win the game
        if (position+1>=game.length){
            return true;
        } // a position ahead wins the game
        if (game[position+1] == 0 && recursion(leap, game, position+1, map)){
            return true;
        }// a position ahead is free and upon visiting it, you've found a path to win the game
        if (position+leap>=game.length){
            return true;
        }// a position one leap away wins the game
        if (game[position+leap] == 0 && recursion(leap, game, position+leap, map)){
            return true;
        }// a position one leap away is free and upon visiting it, you've found a path to win the game
        return false;
    }

}
