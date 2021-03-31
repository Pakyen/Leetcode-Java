# offer55-1 二叉树的深度(后序遍历、层序遍历)
[offer55-1 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)
参考：[力扣](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/solution/mian-shi-ti-55-i-er-cha-shu-de-shen-du-xian-xu-bia/)
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/%E6%88%AA%E5%B1%8F2021-02-25%2015.48.32.png)
> 树的遍历方式总体分为两类：深度优先搜索（DFS）、广度优先搜索（BFS）；  
> 常见的 DFS ： 先序遍历、中序遍历、后序遍历；  
> 常见的 BFS ： 层序遍历（即按层遍历）  

## 方法一 后续遍历（DFS 深度优先搜索）【递归，max子树深度+1】
* 树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。
* 关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1 
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/70691D94-0596-4CE8-AEE7-77584798728A.png)
### 算法解析
1. **终止条件**：当root为空，说明已经越过叶节点，返回深度0
2. **递推工作**：本质上是对树作后序遍历
	1. 计算节点root的左子树的深度，即调用maxDepth(root.left)；
	2. 计算节点root的右子树的深度，即调用maxDepth(root.right);
3. **返回值**：返回此树的深度，即：
max(maxDepth(root.left),maxDepth(root.right))+1;

### 复杂度分析：
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/%E6%88%AA%E5%B1%8F2021-02-25%2016.00.01.png)

### 代码
```
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int deep1 = maxDepth(root.left);
        int deep2 = maxDepth(root.right);
        return Math.max(deep1,deep2)+1;
    }
}
```



## 方法二 层次遍历（BFS 广度优先搜索）【两个队列遍历每一层】
* 树的层序遍历 / 广度优先搜索往往利用 **队列** 实现。
* **关键点：** 每遍历一层，则计数器 +1 ，直到遍历完成，则可得到树的深度。

**算法解析**：
1. 特例处理： 当 root​ 为空，直接返回 深度0
2. 初始化： 队列 queue （加入根节点 root ），计数器 res = 0
3. 循环遍历： 当 queue 为空时跳出
	1. 初始化一个空列表 tmp ，用于临时存储下一层节点；
	2. 遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
	3. 更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
	4. 统计层数： 执行 res += 1 ，代表层数加1；
4. 返回值： 返回 res 即可。
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/097EA45A-CC9B-4B8D-8918-8BF20C9DA7BB.png)
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/392CCFC4-153B-4C5F-9A02-FD261FE961DA.png)
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/792D91A2-15B3-45C9-BEF7-D8547225106F.png)
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/1728080A-C71E-4676-B191-97B1FE8A73BC.png)
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/87942FCB-B4A1-4B83-8E6E-B5C1CCA9E8FF.png)

### 复杂度分析
![](offer55-1%20%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%B7%B1%E5%BA%A6(%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E3%80%81%E5%B1%82%E5%BA%8F%E9%81%8D%E5%8E%86)/%E6%88%AA%E5%B1%8F2021-02-25%2016.07.34.png)

### Code
```
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
```