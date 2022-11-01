package number;

public class Solution_129 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 129. 求根节点到叶节点数字之和
     * https://leetcode.cn/problems/sum-root-to-leaf-numbers/
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int parentVal) {
        if(root == null) {
            return 0;
        }
        parentVal = root.val + 10 * parentVal;
        if(root.left == null && root.right == null) {
            return parentVal;
        }
        return sumNumbers(root.left, parentVal) + sumNumbers(root.right, parentVal);

    }


}
