# (难)offer68-2 二叉树的最近公共祖先（后序遍历DFS） 

![]((%E9%9A%BE)offer68-2%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88%EF%BC%88%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86DFS%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-25%2019.05.42.png)
题目：[offer68-2](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)
参考：[力扣](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-ii-er-cha-shu-de-zui-jin-gong-gon-7/)

## 解题思路：
* 祖先的定义：若节点 p 在节点 root 的左（右）子树中，或 p=root ，则称 root 是 p 的祖先
![]((%E9%9A%BE)offer68-2%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88%EF%BC%88%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86DFS%EF%BC%89/CD26382B-B94A-48FB-BCDE-740BACA27A0A.png)
* 最近公共祖先的定义：::设节点root为根节点p，q的某公共祖先，若其左子节点和右子节点都不是p,q的公共祖先，那么root是最近的公共祖先::

根据以上定义，若root是p,q的最近公共祖先，则只可能为以下情况之一：
	1. p,q分别在root的左子树和右子树中
	2. p = root, 且q在root的左/右子树中
	3. q = root, 且p在root的左/右子树中
![]((%E9%9A%BE)offer68-2%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88%EF%BC%88%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86DFS%EF%BC%89/22A001BF-A1F6-4A43-8C1B-5BBE30A2521C.png)

## 思路
![]((%E9%9A%BE)offer68-2%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88%EF%BC%88%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86DFS%EF%BC%89/5E3EE0CA-E74F-4B1F-95F9-43349C9ADF1B.png)
向下递归，
1. 如果遇到叶子结点，返回null
2. 如果遇到p或者q，返回root==p或者root==q
3. 最后判断，如果left==null，那么就返回right
4. 如果left不为空，right为空，返回left
5. 如果左/右都不为空，返回root
### 代码
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
```

- - - -
## 分析
### 递归解析：
![]((%E9%9A%BE)offer68-2%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88%EF%BC%88%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86DFS%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-25%2019.38.32.png)









