package Tree.offer55_1;


import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//DFS
//class Solution {
//    public int maxDepth(TreeNode root) {
//        if(root==null) return 0;
//        int deep1 = maxDepth(root.left);
//        int deep2 = maxDepth(root.right);
//        return Math.max(deep1,deep2)+1;
//    }
//}

//BFS
class Solution{
    public  int maxDepth(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        while(!queue.isEmpty()){
            Queue<TreeNode> tmp = new LinkedList<>();
            for(TreeNode node : queue){
                if(node.left != null) tmp.add(node.left);
                if(node.right!= null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}