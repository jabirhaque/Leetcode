import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PrintTree {
    public static void main(String[] args){
        System.out.println(printTree(new TreeNode(1, new TreeNode(2), null)));
    }

    public static List<List<String>> printTree(TreeNode root) {
        int depth = depth(root)-1;
        List<List<String>> result = new ArrayList<>();
        for (int i=0; i<depth+1; i++){
            List<String> list = new ArrayList<>();
            for (int j=0; j<(int)Math.pow(2, depth+1)-1; j++) list.add("");
            result.add(list);
        }
        return dfs(root, 0, result.get(0).size()/2, result);
    }

    private static int depth(TreeNode node){
        if (node == null) return 0;
        return 1+Math.max(depth(node.left), depth(node.right));
    }

    private static List<List<String>> dfs(TreeNode node, int i, int j, List<List<String>> result){
        if (node == null) return result;
        result.get(i).set(j, ""+node.val);
        dfs(node.left, i+1, j-(int)Math.pow(2, result.size()-2-i), result);
        return dfs(node.right, i+1, j+(int)Math.pow(2, result.size()-2-i), result);
    }
}