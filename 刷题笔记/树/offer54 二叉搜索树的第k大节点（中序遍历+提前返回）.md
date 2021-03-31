# offer54 二叉搜索树的第k大节点（中序遍历+提前返回）
题目：[offer54](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/)
参考：[力扣](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/)
![](offer54%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E7%AC%ACk%E5%A4%A7%E8%8A%82%E7%82%B9%EF%BC%88%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86+%E6%8F%90%E5%89%8D%E8%BF%94%E5%9B%9E%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-25%2016.38.14.png)
* 根据以上性质，易得**二叉搜索树的 中序遍历倒序 为 递减序列** 。
* 因此，求 “二叉搜索树第 k 大的节点” 可转化为求 “此树的中序遍历倒序的第 k 个节点”
![](offer54%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E7%AC%ACk%E5%A4%A7%E8%8A%82%E7%82%B9%EF%BC%88%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86+%E6%8F%90%E5%89%8D%E8%BF%94%E5%9B%9E%EF%BC%89/11DBCCE8-144C-487D-B229-2CFC6464B038.png)
![](offer54%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E7%AC%ACk%E5%A4%A7%E8%8A%82%E7%82%B9%EF%BC%88%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86+%E6%8F%90%E5%89%8D%E8%BF%94%E5%9B%9E%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-25%2016.41.43.png)
![](offer54%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E7%AC%ACk%E5%A4%A7%E8%8A%82%E7%82%B9%EF%BC%88%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86+%E6%8F%90%E5%89%8D%E8%BF%94%E5%9B%9E%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-25%2016.42.21.png)

### 算法思想
* 为求第k个节点，需要实现以下 三项工作 ：
	1. 递归遍历时计数，统计当前节点的序号；
	2. 递归到第 k 个节点时，应记录结果 res ；
	3. 记录结果后，后续的遍历即失去意义，应提前终止（即返回）

### 递归解析：
	1. **终止条件**：当节点root为空（越过叶节点），则直接返回
	2. **递归右子树**：即dfs(root.right);
	3. 三项工作：
		1. 提前返回：若k=0，证明已经找到了目标节点，无序继续遍历，提前返回
		2. 统计序号：执行k=k-1；（从k减到0）
		3. 记录结果：若k=0，代表当前节点为第k大的节点，因此记录res=root.val;
	4. 递归左子树：即dfs(root.left);
![](offer54%20%E4%BA%8C%E5%8F%89%E6%90%9C%E7%B4%A2%E6%A0%91%E7%9A%84%E7%AC%ACk%E5%A4%A7%E8%8A%82%E7%82%B9%EF%BC%88%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86+%E6%8F%90%E5%89%8D%E8%BF%94%E5%9B%9E%EF%BC%89/%E6%88%AA%E5%B1%8F2021-02-25%2016.46.21.png)
### Code
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
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    //倒序的中序遍历 右根左
    void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.right);
        if(k==0) return;
        if(--k==0) res = root.val;
        dfs(root.left);
    }
}
```