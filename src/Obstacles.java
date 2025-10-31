import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Obstacles {
    public static void main(String[] args){
        System.out.println(minSideJumps(new int[]{0,1,2,3,0}));
    }

    public static int minSideJumps(int[] obstacles) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        for (int i=0; i<obstacles.length; i++){
            if (obstacles[i] == 1) list1.add(i);
            if (obstacles[i] == 2) list2.add(i);
            if (obstacles[i] == 3) list3.add(i);
        }
        list1.add(obstacles.length);
        list2.add(obstacles.length);
        list3.add(obstacles.length);
        int count = 0;
        int lane = 2;
        for (int i=0; i<obstacles.length-1; i++){
            if (obstacles[i+1] == lane){
                count++;

                int index1 = Collections.binarySearch(list1, i);
                if (index1<0) index1 = -(1+index1);
                int dis1 = list1.get(index1) - i;

                int index2 = Collections.binarySearch(list2, i);
                if (index2<0) index2 = -(1+index2);
                int dis2 = list2.get(index2) - i;

                int index3 = Collections.binarySearch(list3, i);
                if (index3<0) index3 = -(1+index3);
                int dis3 = list3.get(index3) - i;
                if (lane == 1){
                    if (dis2>dis3) lane = 2;
                    else lane = 3;
                }
                else if (lane == 2){
                    if (dis1>dis3) lane = 1;
                    else lane = 3;
                }else{
                    if (dis1>dis2) lane = 1;
                    else lane = 2;
                }
            }
        }
        return count;
    }
}