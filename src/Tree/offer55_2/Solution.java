package Tree.offer55_2;

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
    public boolean isBalanced(TreeNode root) {
        return recur(root)!=-1;
    }
    private int recur(TreeNode root){
        if(root==null) return 0;
        int left =recur(root.left);
        int right = recur(root.right);
        if(left==-1) return -1;
        if(right==-1) return -1;
        return Math.abs(left-right)<=1 ? Math.max(left,right)+1 : -1;
    }
}