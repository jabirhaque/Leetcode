import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FurtherBuilding {
    public static void main(String[] args){
        System.out.println(furthestBuilding(new int[] {1,13,1,1,13,5,11,11}, 5, 1));
    }

    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        List<Integer> list = new ArrayList<>(List.of(0));
        int i=0;
        while (i<heights.length-1){
            int diff = heights[i+1]-heights[i];
            if (diff<=0) {
                i++;
                continue;
            }
            if (diff<=bricks){
                bricks-=diff;
                int index = Collections.binarySearch(list, diff);
                if (index<0) index = -(1+index);
                list.add(index, diff);
            }else{
                if (ladders<1) break;
                ladders--;
                int biggest = list.get(list.size()-1);
                if (biggest>diff){
                    list.remove(list.size()-1);
                    bricks+=biggest;
                    bricks-=diff;
                    int index = Collections.binarySearch(list, diff);
                    if (index<0) index = -(1+index);
                    list.add(index, diff);
                }
            }
            i++;
        }
        return i;
    }
}