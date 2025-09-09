import java.util.ArrayList;
import java.util.List;

public class seats {
    public static void main(String[] args){
        System.out.println(seat(new ArrayList<>(List.of(0)), 10));
    }
    public static List<Integer> seat(List<Integer> taken, int n) {
        if (taken.size() == 0){
            taken.add(0);
            return taken;
        }else{
            int max = 0; //max gap
            int last = -1; //last seat not index
            int val = -1; //inserted seat
            int index = -1; //inserted pos
            for (int i=0; i<taken.size(); i++){
                if (last == -1){
                    if (taken.get(i) > max){
                        max = taken.get(i);
                        val = 0;
                        index = 0;
                    }
                    last = taken.get(i);
                }else{
                    if ((taken.get(i)-last)/2 > max){
                        max = (taken.get(i)-last)/2;
                        val = last + max;
                        index = i;
                    }
                    last = taken.get(i);
                }
            }
            if (n-1-last>max){
                max = n-1-last;
                val = n-1;
                index = taken.size();
            }
            taken.add(index, val);
            return taken;
        }
    }
}
