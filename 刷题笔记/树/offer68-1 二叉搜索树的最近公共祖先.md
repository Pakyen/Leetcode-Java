# offer68-1 二叉搜索树的最近公共祖先
[力扣](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

设x是p,q的某公共祖先，那么如果x的左右孩子都不能是p, q的公共祖先，那x就是最近公共祖先

1 p,q分别在root的左/右子树中

2 p = root 且q在root的左/右子树中

3 q = root 且p在root的左/右子树中
- - - -
![](offer68-1%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/1E0BBC6B-E670-47C1-AA9A-D069001D9190.png)
本题给定了两个重要条件：
	① 树为 二叉搜索树 ，
	② 树的所有节点的值都是 唯一 的
根据以上条件，可方便地判断p,q与root的子树关系：
	* 若root.val < p.val，则p在root右子树中
	* 若root.val > p.val，则p在root左子树中
	* 若root.val = p.val，则p和root指向同一个节点
	

## 方法一 迭代
![](offer68-1%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/%E6%88%AA%E5%B1%8F2021-03-03%2009.50.34.png)
> 对于1.3, 如果p,q在异侧，那么root就是p,q的最近公共祖先  
```
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val<root.val && q.val<root.val){
                root = root.left;
            }
            else if(p.val>root.val && q.val>root.val){
                root = root.right;
            }
            else break;
        }
        return root;
    }
}
```


## 方法二 递归
![](offer68-1%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/%E6%88%AA%E5%B1%8F2021-03-03%2010.31.43.png)


