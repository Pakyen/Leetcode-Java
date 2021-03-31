# offer32-2 从上到下打印二叉树II
![](offer32-2%20%E4%BB%8E%E4%B8%8A%E5%88%B0%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91II/%E6%88%AA%E5%B1%8F2021-03-03%2011.09.43.png)

此题和31-1差不多，看着很简单，只需要按层打印，但是一开始没做出来
![](offer32-2%20%E4%BB%8E%E4%B8%8A%E5%88%B0%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91II/B7DA1E86-5F0B-4E5E-81B7-FC3FD7C6CA00.png)
## 解题思路（层次遍历, BFS）用两个队列
[力扣](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/solution/mian-shi-ti-32-ii-cong-shang-dao-xia-da-yin-er-c-5/)
 一个队列queue，一个列表List tmp，列表tmp用于保存当层的结果；
![](offer32-2%20%E4%BB%8E%E4%B8%8A%E5%88%B0%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91II/9A587126-A479-4220-B166-27A84AC36D06.png)
![](offer32-2%20%E4%BB%8E%E4%B8%8A%E5%88%B0%E4%B8%8B%E6%89%93%E5%8D%B0%E4%BA%8C%E5%8F%89%E6%A0%91II/%E6%88%AA%E5%B1%8F2021-03-03%2011.28.06.png)
### 注意事项
* 因为要返回的是二维列表，所以当root为空时怎么返回呢？
	* 直接root非空再入队即可，否则返回的就是空的res

> 循环（当queue不为空）:  
> 		新建一个List tmp， ~来保存这一层的节点~  
> 		对于queue中的::每::个节点：  
> 			1. 将它们的值加入tmp（node=queue.poll()）【出队+打印】  
> 			2. 将子节点加入queue【添加子节点】  
> 		res.add(tmp)  

```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null) queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int len = queue.size();
            while(len-- > 0){
                TreeNode node = queue.poll();
                //输出每一层，就是保存每一层的当前节点
                tmp.add(node.val);
                //子节点入队 queue 而不是tmp
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
```