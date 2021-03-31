# offer34 二叉树中和为某一值的路径（回溯法）【难，背】

## 题目描述
[offer34](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)
![](offer34%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84%EF%BC%88%E5%9B%9E%E6%BA%AF%E6%B3%95%EF%BC%89%E3%80%90%E9%9A%BE%EF%BC%8C%E8%83%8C%E3%80%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.36.33.png)


## 解题思路（先序遍历，路径记录，两个列表（路径和结果））
> 本问题是典型的二叉树方案搜索问题，使用回溯法解决  
> 其包含 **先序遍历 + 路径记录** 两部分  
![](offer34%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84%EF%BC%88%E5%9B%9E%E6%BA%AF%E6%B3%95%EF%BC%89%E3%80%90%E9%9A%BE%EF%BC%8C%E8%83%8C%E3%80%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.40.38.png)

### 算法流程
<a href='%E5%B1%8F%E5%B9%95%E5%BD%95%E5%88%B62021-03-06%2013.46.33.mov'>屏幕录制2021-03-06 13.46.33.mov</a>
![](offer34%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84%EF%BC%88%E5%9B%9E%E6%BA%AF%E6%B3%95%EF%BC%89%E3%80%90%E9%9A%BE%EF%BC%8C%E8%83%8C%E3%80%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.47.40.png)

### 复杂度分析
![](offer34%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84%EF%BC%88%E5%9B%9E%E6%BA%AF%E6%B3%95%EF%BC%89%E3%80%90%E9%9A%BE%EF%BC%8C%E8%83%8C%E3%80%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.50.37.png)


### 代码
![](offer34%20%E4%BA%8C%E5%8F%89%E6%A0%91%E4%B8%AD%E5%92%8C%E4%B8%BA%E6%9F%90%E4%B8%80%E5%80%BC%E7%9A%84%E8%B7%AF%E5%BE%84%EF%BC%88%E5%9B%9E%E6%BA%AF%E6%B3%95%EF%BC%89%E3%80%90%E9%9A%BE%EF%BC%8C%E8%83%8C%E3%80%91/%E6%88%AA%E5%B1%8F2021-03-06%2013.50.55.png)

```
class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar){
        if(root==null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar==0 && root.left==null && root.right==null)
            res.add(new LinkedList<>(path)); //不能直接加path，直接加path加的是path对象，
                                            // 后序path改变时，res中的path对象也会改变，所以要 res.add(new LinkedList<>(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}
```