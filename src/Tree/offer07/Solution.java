package Tree.offer07;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

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
    //利用原理,先序遍历的第一个节点就是根
    //在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    HashMap<Integer,Integer> dic = new HashMap<>();//标记中序遍历<值，索引>
    int[] preorder; //保留的先序遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0,inorder.length-1);
        //当前根的索引，递归树的左边界，递归树的右边界
    }
    /*
    @param root：先序遍历的索引
    @param left：中序遍历的索引
    @param right：中序遍历的索引
     */
    TreeNode recur(int root, int left, int right){
        if(left>right) return null;                         //递归终止条件
        TreeNode node = new TreeNode(preorder[root]);       //建立根节点
        int i = dic.get(preorder[root]);                    //划分左右子树
        node.left = recur(root+1,left,i-1);       //开启左子树递归
        node.right = recur(root+i-left+1,i+1,right);//开启右子树递归
        return node;
    }
}