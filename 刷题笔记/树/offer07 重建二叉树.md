# offer07 重建二叉树
[[1 树]]
[[2 二叉树先序、中序、后序遍历]]
[[3 二叉树的存储结构（顺序和链式）]]
[[4 二叉树的性质]]
题目：
[力扣](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)
## 递归法
参考：[力扣](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/)
### 解题思路：
> 前序遍历：根，左，右  
> 中序遍历：左，根，右  

根据以上性质，可以得出结论：
1. 前序遍历的首元素为树的根节点node的值
2. 在中序遍历中搜索根节点 node 的索引 ，可将 中序遍历 划分为 [ 左子树 | 根节点 | 右子树 ] 
3. 根据中序遍历中的左 / 右子树的节点数量，可将 前序遍历 划分为 [ 根节点 | 左子树 | 右子树 ] 
![](offer07%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91/EDE42729-C7D8-4E0F-A09D-135ACF322683.png)
> 通过以上三步，可确定 **三个节点** ：1.树的根节点、2.左子树根节点、3.右子树根节点  
> 对于树的左、右子树，仍可使用以上步骤划分子树的左右子树  
以上子树的递推性质是 **分治算法** 的体现，考虑通过递归对所有子树进行划分

### 分治算法解析
* ::递归参数::：根节点在前序遍历的索引 root 、子树在中序遍历的左边界 left 、子树在中序遍历的右边界 right
* ::终止条件::：当 left > right ，代表已经越过叶节点，此时返回*null*；
* ::递推工作::：
	1. 建立根节点node：节点值为preorder[root]
	2. 划分左右子树：查找根节点在中序遍历inorder中的索引i

> 为了提升效率，（因为此二叉树没有重复节点值）使用哈希表 dic 存储中序遍历的值与索引的映射，查找操作的时间复杂度为*O*(1)  

	3. 构建左右子树：开启左右子树递归；
![](offer07%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-02-25%2015.08.15.png)
> `i - left + root + 1` 含义为 根节点索引 + 左子树长度 + 1  

* ::返回值::：回溯返回node，作为上一层递归中根节点的左/右子节点

### 复杂度分析：
![](offer07%20%E9%87%8D%E5%BB%BA%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-02-25%2015.14.06.png)

### 代码：
```
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
```