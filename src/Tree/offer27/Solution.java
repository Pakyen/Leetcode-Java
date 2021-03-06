package Tree.offer27;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        TreeNode t = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(t);
        return root;
    }
}