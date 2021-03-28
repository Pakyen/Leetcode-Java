package Backtracking.Combination;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Leetcode77 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return res;
    }
    private void backTracking(int n, int k, int startIndex){
        if(path.size()==k){
            res.add(new ArrayList<>(path));  //不能直接加path，直接加path得到的是path对象，最后回溯完会得到一堆空值
            return;
        }
        for (int i = startIndex; i <= n ; i++) {
            path.add(i);                     //处理结点
            backTracking(n,k,i+1);  //递归
            path.remove(path.size()-1);//回溯,撤销处理的结点
        }
    }
}
