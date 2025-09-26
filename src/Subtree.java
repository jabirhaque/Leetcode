import com.sun.source.tree.Tree;

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
class Subtree {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(subtreeWithAllDeepest(root));
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        List<List<TreeNode>> list = dfs(root, new ArrayList<>(), new ArrayList<>());
        int max = 0;
        for (List<TreeNode> l: list){
            max = Math.max(max, l.size());
        }
        List<List<TreeNode>> filtered = new ArrayList<>();
        for (List<TreeNode> l: list){
            if (l.size() == max){
                filtered.add(l);
            }
        }
        TreeNode res = common(filtered);
        return res;
    }

    private static TreeNode common(List<List<TreeNode>> filtered){
        int i=0;
        while (valid(i, filtered))i++;
        return filtered.getFirst().get(i-1);
    }

    private static boolean valid(int i, List<List<TreeNode>> filtered){
        if (i>=filtered.get(0).size()) return false;
        for (int j=1; j<filtered.size(); j++){
            if (filtered.get(j).get(i) != filtered.get(j-1).get(i)) return false;
        }
        return true;
    }

    private static List<List<TreeNode>> dfs(TreeNode node, List<TreeNode> current, List<List<TreeNode>> result){
        if (node == null) return result;
        if (node.left == null && node.right == null){
            List<TreeNode> newCurrent = new ArrayList<>(current);
            newCurrent.add(node);
            result.add(newCurrent);
            return result;
        }
        current.add(node);
        dfs(node.left, current, result);
        dfs(node.right, current, result);
        current.remove(current.size()-1);
        return result;
    }
}