package Tree.offer32_2;

import Tree.offer55_1.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root!=null) queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int len = queue.size();
            while(len-->0){
                //对于queue中每一个节点，将它们的值加入tmp（不能直接将子节点的值加入tmp，那样就不是层次遍历）
                //并将子节点加入queue
                //queue.poll()
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}