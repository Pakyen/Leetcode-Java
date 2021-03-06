package Tree.offer54;

import Tree.offer55_1.TreeNode;

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
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    //倒序的中序遍历 右根左
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);
        if(k==0) return;
        if(--k==0) res = root.val;
        dfs(root.left);
    }
}