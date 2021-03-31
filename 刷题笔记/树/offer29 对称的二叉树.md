# offer29 对称的二叉树

## 题目描述
[力扣](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)
![](offer29%20%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.06.46.png)


## 解题思路
对称二叉树的定义：
![](offer29%20%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.17.54.png)
![](offer29%20%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91/EB596B52-0F31-467E-A832-06D0B12467B0.png)
### 算法流程
![](offer29%20%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91/8419B078-9038-4A36-BF46-7B2475A71AB9.png)

### 复杂度分析
![](offer29%20%E5%AF%B9%E7%A7%B0%E7%9A%84%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.21.48.png)

### 代码
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null ^ R == null) return false;
        if (L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right,R.left);
    }
}
```