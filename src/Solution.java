class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public static void main(String[] args){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        return recursion(root, Integer.MIN_VALUE);
    }

    private static int recursion(TreeNode node, int max){
        if (node == null){
            return 0;
        }
        max = recursion(node.left, max);
        max = recursion(node.right, max);
        int left = node.left==null?0:node.left.val;
        int right = node.right==null?0:node.right.val;
        int preVal = node.val;
        node.val = node.val+Math.max(left, right);
        max = Math.max(max, preVal+left);
        max = Math.max(max, preVal+right);
        return Math.max(max, preVal+left+right);
    }
}