import java.util.LinkedList;
import java.util.Queue;

public class Party {
    public static void main(String[] args){
        System.out.println(predictPartyVictory("DR"));
    }
    public static String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        for (char c:senate.toCharArray()){
            q.add(c);
        }
        int count = 0;
        int r=0;
        int d=0;
        while (count<q.size()){
            if (q.remove() == 'R'){
                if (r>0){
                    r--;
                    count=0;
                }else{
                    q.add('R');
                    d++;
                    count++;
                }
            }
            else{
                if (d>0){
                    d--;
                    count=0;
                }else{
                    q.add('D');
                    r++;
                    count++;
                }
            }
        }
        return q.remove()=='R'?"Radiant":"Dire";
    }
}
