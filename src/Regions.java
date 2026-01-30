import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RegionsNode{
    boolean visited;
    List<RegionsNode> neighbours;
    RegionsNode(){
        this.visited = false;
        this.neighbours = new ArrayList<>();
    }
}

class Regions {
    public static void main(String[] args){
        System.out.println(regionsBySlashes(new String[]{"/\\","\\/"}));
    }

    public static int regionsBySlashes(String[] grid) {
        int[][] matrix = new int[grid.length][grid.length];
        for (int i=0; i<grid.length; i++){
            int j = 0;
            int k = 0;
            while (j<grid[i].length()){
                if (grid[i].charAt(j) == ' ') matrix[i][k] = 0;
                else if (grid[i].charAt(j) == '/') matrix[i][k] = 1;
                else matrix[i][k] = 2;
                j++;
                k++;
            }
        }
        Map<String, RegionsNode> whole = new HashMap<>();
        Map<String, RegionsNode> topLeft = new HashMap<>();
        Map<String, RegionsNode> topRight = new HashMap<>();
        Map<String, RegionsNode> bottomLeft = new HashMap<>();
        Map<String, RegionsNode> bottomRight = new HashMap<>();
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix.length; j++){
                String key = i+","+j;
                if (matrix[i][j] == 0){
                    whole.put(key, new RegionsNode());
                }
                if (matrix[i][j] == 1){
                    topLeft.put(key, new RegionsNode());
                    bottomRight.put(key, new RegionsNode());
                }
                if (matrix[i][j] == 2){
                    topRight.put(key, new RegionsNode());
                    bottomLeft.put(key, new RegionsNode());
                }
            }
        }
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix.length; j++){
                String key = i+","+j;
                RegionsNode up = null;
                RegionsNode down = null;
                RegionsNode left = null;
                RegionsNode right = null;
                if (i-1 >= 0){
                    if (whole.containsKey((i-1)+","+j)) up = whole.get((i-1)+","+j);
                    if (bottomLeft.containsKey((i-1)+","+j)) up = bottomLeft.get((i-1)+","+j);
                    if (bottomRight.containsKey((i-1)+","+j)) up = bottomRight.get((i-1)+","+j);
                }
                if (i+1 < matrix.length){
                    if (whole.containsKey((i+1)+","+j)) down = whole.get((i+1)+","+j);
                    if (topLeft.containsKey((i+1)+","+j)) down = topLeft.get((i+1)+","+j);
                    if (topRight.containsKey((i+1)+","+j)) down = topRight.get((i+1)+","+j);
                }
                if (j-1 >= 0){
                    if (whole.containsKey(i+","+(j-1))) left = whole.get(i+","+(j-1));
                    if (topRight.containsKey(i+","+(j-1))) left = topRight.get(i+","+(j-1));
                    if (bottomRight.containsKey(i+","+(j-1))) left = bottomRight.get(i+","+(j-1));
                }
                if (j+1 < matrix.length){
                    if (whole.containsKey(i+","+(j+1))) right = whole.get(i+","+(j+1));
                    if (topLeft.containsKey(i+","+(j+1))) right = topLeft.get(i+","+(j+1));
                    if (bottomLeft.containsKey(i+","+(j+1))) right = bottomLeft.get(i+","+(j+1));
                }
                if (whole.containsKey(key)){
                    RegionsNode node = whole.get(key);
                    if (up != null) node.neighbours.add(up);
                    if (down != null) node.neighbours.add(down);
                    if (left != null) node.neighbours.add(left);
                    if (right != null) node.neighbours.add(right);
                }
                else {
                    RegionsNode node = topLeft.getOrDefault(key, topRight.get(key));
                    if (up != null) node.neighbours.add(up);
                    node = bottomLeft.getOrDefault(key, bottomRight.get(key));
                    if (down != null) node.neighbours.add(down);
                    node = topLeft.getOrDefault(key, bottomLeft.get(key));
                    if (left != null) node.neighbours.add(left);
                    node = topRight.getOrDefault(key, bottomRight.get(key));
                    if (right != null) node.neighbours.add(right);
                }
            }
        }
        int count = 0;
        for (String str: whole.keySet()){
            RegionsNode node = whole.get(str);
            if (!node.visited){
                visit(node);
                count++;
            }
        }
        for (String str: topLeft.keySet()){
            RegionsNode node = topLeft.get(str);
            if (!node.visited){
                visit(node);
                count++;
            }
        }
        for (String str: topRight.keySet()){
            RegionsNode node = topRight.get(str);
            if (!node.visited){
                visit(node);
                count++;
            }
        }
        for (String str: bottomLeft.keySet()){
            RegionsNode node = bottomLeft.get(str);
            if (!node.visited){
                visit(node);
                count++;
            }
        }
        for (String str: bottomRight.keySet()){
            RegionsNode node = bottomRight.get(str);
            if (!node.visited){
                visit(node);
                count++;
            }
        }
        return count;
    }

    private static void visit(RegionsNode node){
        if (node.visited) return;
        node.visited = true;
        for (RegionsNode next: node.neighbours) visit(next);
    }
}