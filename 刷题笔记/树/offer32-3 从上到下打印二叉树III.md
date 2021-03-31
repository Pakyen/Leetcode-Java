# offer32-3 从上到下打印二叉树III


[力扣](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)
一个队列，一个list temp
设置打印 变量layer，控制打印顺序（奇偶分离）

当queue不为空时：
	先创建tmp
	对每一层来说，如果layer++%2==0？正序：倒叙
	然后while(len-->0)循环
		按照正序 or 倒叙添加node.val到tmp中。
		顺便把每一个node的左右孩子添加到queue中

```
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root!=null) queue.add(root);
        int layer = 0;
        while(!queue.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            int len = queue.size();
            if(layer++%2==0){
                //正序
                while(len-->0){
                    TreeNode node = queue.poll();
                    tmp.add(node.val);
                    if(node.left!=null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                }
            }
            else{
                //倒叙
                while(len-->0){
                    TreeNode node = queue.poll();
                    tmp.add(0,node.val);
                    if(node.left!=null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}

```