# offer32-1 从上到下打印二叉树
![](offer32-1%20%E4%BB%8E%E4%B8%8A%E5%88%B0%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-03-03%2010.44.16.png)
层次遍历（BFS，广度优先搜索）
[力扣](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/mian-shi-ti-32-i-cong-shang-dao-xia-da-yin-er-ch-4/#comment)
## 解题思路（层次遍历，BFS）
* 使用一个队列，一个ArrayList
* 从root开始循环，直到queue为空
* while(!queue.isEmpty()
	* 将节点的值加入res，并将该节点出队 queue.poll()
	* 如果该节点有左孩子，加入queue
	* 如果该节点有右孩子，加入queue
	（因为队列先进先出，兄弟节点肯定在子节点的前面）
* 最后将ArrayList转Array即可(for loop)
![](offer32-1%20%E4%BB%8E%E4%B8%8A%E5%88%B0%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91/%E6%88%AA%E5%B1%8F2021-03-03%2011.08.16.png)

代码：
```
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> res = new ArrayList<>();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
            // 因为队列先进先出，兄弟节点肯定在子节点的前面
        }
        // ArrayList转array
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);

        return result;
    }
}
```