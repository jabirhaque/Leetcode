import java.util.*;

class WalkingRobot {
    public static void main(String[] args){
        System.out.println(robotSim(new int[]{6,9,-2,-1,-2}, new int[][]{
                {-1, -3},
                {1, 1},
                {-1, 5},
                {3, 4},
                {3, 4},
                {-5, -4},
                {5, -4},
                {3, 5},
                {-5, -2},
                {-4, -2}
        }));
    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        obstacles = unique(obstacles);
        Map<Integer, List<Integer>> mapx = new HashMap<>();
        Map<Integer, List<Integer>> mapy = new HashMap<>();
        for (int[] obstacle: obstacles){
            if (mapx.containsKey(obstacle[0])){
                int index = -(1+ Collections.binarySearch(mapx.get(obstacle[0]), obstacle[1]));
                mapx.get(obstacle[0]).add(index, obstacle[1]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(obstacle[1]);
                mapx.put(obstacle[0], list);
            }
            if (mapy.containsKey(obstacle[1])){
                int index = -(1+Collections.binarySearch(mapy.get(obstacle[1]), obstacle[0]));
                mapy.get(obstacle[1]).add(index, obstacle[0]);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(obstacle[0]);
                mapy.put(obstacle[1], list);
            }
        }

        int max = 0;
        int x = 0;
        int y = 0;
        int dir = 0;

        for (int command: commands){
            if (command == -1) dir++;
            else if (command == -2) dir += 3;
            else{
                if (dir%4 == 0){
                    if (mapx.containsKey(x)){
                        int index = Collections.binarySearch(mapx.get(x), y);
                        if (index<0) index = -(1+index);
                        else if (y>=0) index++;
                        if (index>=mapx.get(x).size()){
                            y+=command;
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }else{
                            y=Math.min(mapx.get(x).get(index)-1, y+command);
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }
                    }else{
                        y+=command;
                        max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                    }
                }
                if (dir%4 == 2){
                    if (mapx.containsKey(x)){
                        int index = Collections.binarySearch(mapx.get(x), y);
                        if (index<0) index = -(1+index);
                        else if (y<=0) index--;
                        if (index-1<0){
                            y-=command;
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }else{
                            y=Math.max(mapx.get(x).get(index-1)+1, y-command);
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }
                    }else{
                        y-=command;
                        max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                    }
                }

                if (dir%4 == 1){
                    if (mapy.containsKey(y)){
                        int index = Collections.binarySearch(mapy.get(y), x);
                        if (index<0) index = -(1+index);
                        else if (x>=0) index++;
                        if (index>=mapy.get(y).size()){
                            x+=command;
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }else{
                            x=Math.min(mapy.get(y).get(index)-1, x+command);
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }
                    }else{
                        x+=command;
                        max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                    }
                }
                if (dir%4 == 3){
                    if (mapy.containsKey(y)){
                        int index = Collections.binarySearch(mapy.get(y), x);
                        if (index<0) index = -(1+index);
                        else if (x<=0) index--;
                        if (index-1<0){
                            x-=command;
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }else{
                            x=Math.max(mapy.get(y).get(index-1)+1, x-command);
                            max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                        }
                    }else{
                        x-=command;
                        max = Math.max(max, (int)(Math.pow(x, 2)+Math.pow(y, 2)));
                    }
                }
            }
        }
        return max;
    }

    private static int[][] unique(int[][] array){
        Set<String> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int[] arr: array){
            String key = arr[0]+","+arr[1];
            if (!set.contains(key)){
                set.add(key);
                list.add(List.of(arr[0], arr[1]));
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i=0; i<res.length; i++){
            res[i][0] = list.get(i).get(0);
            res[i][1] = list.get(i).get(1);
        }
        return res;
    }
}