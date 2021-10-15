package NewCoder;

/**
 * @author hbx
 * @date 2021-08-05 3:57 PM
 */
public class NC13 {
    public int maxDepth (TreeNode root) {
        if(root==null) return 0;
        int deep1 = maxDepth(root.left);
        int deep2 = maxDepth(root.right);
        return Math.max(deep1,deep2)+1;
    }
}
