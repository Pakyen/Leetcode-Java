# offer55-2 平衡二叉树II
![](offer55-2%20%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91II/%E6%88%AA%E5%B1%8F2021-03-04%2014.00.17.png)
看着简单，但一开始没做出来

::以下两种方法均基于以下性质推出： **此树的深度** 等于 **左子树的深度** 与 **右子树的深度** 中的 **最大值**+1::

## 方法：后序遍历+剪枝（从底至顶）
【一个函数返回深度，如果不平衡返回-1】
【终止条件，root==null 就 return0 ｜｜ 或者 recur(子树)的结果是-1就直接返回-1】
【主函数判断，如果recur(root)==-1，就返回false，否则返回true】
![](offer55-2%20%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91II/65AF2A27-9510-4C35-8F1E-5B31D57D4AFA.png)
![](offer55-2%20%E5%B9%B3%E8%A1%A1%E4%BA%8C%E5%8F%89%E6%A0%91II/%E6%88%AA%E5%B1%8F2021-03-04%2014.15.52.png)
```
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
```













