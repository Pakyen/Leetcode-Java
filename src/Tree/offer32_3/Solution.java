package Tree.offer32_3;

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
