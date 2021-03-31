# offer27 二叉树的镜像; leetcode 226
![](offer27%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%95%9C%E5%83%8F;%20leetcode%20226/%E6%88%AA%E5%B1%8F2021-02-25%2015.37.02.png)
看着简单，但写不出来这个递归

> 二叉树镜像定义： 对于二叉树中任意节点 root ，设其左 / 右子节点分别为 left,right ；则在二叉树的镜像中的对应 root 节点，其左 / 右子节点分别为 right,left   

### 递归法
```
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
```

### 复杂度分析
![](offer27%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E9%95%9C%E5%83%8F;%20leetcode%20226/%E6%88%AA%E5%B1%8F2021-02-25%2015.47.13.png)