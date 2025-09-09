import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GridNode {
    int val;
    boolean pacific;
    boolean atlantic;
    GridNode(int val){
        this.val = val;
        this.pacific = false;
        this.atlantic = false;
    }
}

class PacificAtlantic {
    public static void main(String[] args){
        System.out.println(pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        GridNode[][] nodes = new GridNode[heights.length][heights[0].length];
        for (int i=0; i<heights.length; i++){
            for (int j=0; j<heights[i].length; j++){
                GridNode node = new GridNode(heights[i][j]);
                nodes[i][j] = node;
            }
        }
        for (int i=0; i<nodes.length; i++){
            for (int j=0; j<nodes[i].length; j++){
                if (i==0 || j==0){
                    Stack<List<Integer>> stack = new Stack<>();
                    stack.push(List.of(i, j));
                    while (!stack.empty()){
                        List<Integer> current = stack.pop();
                        if (nodes[current.get(0)][current.get(1)].pacific == false){
                            nodes[current.get(0)][current.get(1)].pacific = true;
                            if (current.get(0) != 0 && nodes[current.get(0)-1][current.get(1)].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0)-1, current.get(1)));
                            }
                            if (current.get(0) != nodes.length-1 && nodes[current.get(0)+1][current.get(1)].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0)+1, current.get(1)));
                            }
                            if (current.get(1) != 0 && nodes[current.get(0)][current.get(1)-1].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0), current.get(1)-1));
                            }
                            if (current.get(1) != nodes[0].length-1 && nodes[current.get(0)][current.get(1)+1].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0), current.get(1)+1));
                            }
                        }
                    }
                }
                if (i==nodes.length || j==nodes[0].length){
                    Stack<List<Integer>> stack = new Stack<>();
                    stack.push(List.of(i, j));
                    while (!stack.empty()){
                        List<Integer> current = stack.pop();
                        if (nodes[current.get(0)][current.get(1)].atlantic == false){
                            nodes[current.get(0)][current.get(1)].atlantic = true;
                            if (current.get(0) != 0 && nodes[current.get(0)-1][current.get(1)].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0)-1, current.get(1)));
                            }
                            if (current.get(0) != nodes.length-1 && nodes[current.get(0)+1][current.get(1)].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0)+1, current.get(1)));
                            }
                            if (current.get(1) != 0 && nodes[current.get(0)][current.get(1)-1].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0), current.get(1)-1));
                            }
                            if (current.get(1) != nodes[0].length-1 && nodes[current.get(0)][current.get(1)+1].val >= nodes[current.get(0)][current.get(1)].val){
                                stack.push(List.of(current.get(0), current.get(1)+1));
                            }
                        }
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<nodes.length; i++){
            for (int j=0; j<nodes[i].length; j++){
                if (nodes[i][j].pacific && nodes[i][j].atlantic){
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
}