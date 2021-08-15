package Tree;


import Tree.offer55_1.TreeNode;

/**
 * @author hbx
 * @date 2021-08-15 11:41 AM
 */
/*
https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/
 */
public class Leetcode124 {
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
//        left,right分别为根节点左右子树最大路径和
//        注意：如果最大路径和<0,意味着该路径和对总路径和做负贡献，因此不要计入到总路径中，将它设置为0

    int res = Integer.MIN_VALUE; //注意节点值可能为负数，因此要设置为最小值
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }
    public int maxPath(TreeNode node){
        if(node==null){
            return 0;
        }
        //比较当前最大路径和与左右子树最长路径加上根节点值的较大值，更新全局变量
        int left = Math.max(maxPath(node.left),0);
        int right = Math.max(maxPath(node.right),0);
        //返回左右子树较长的路径加上根节点值
        res = Math.max(res,node.val+left+right);
        return node.val+Math.max(left,right);
    }
}
