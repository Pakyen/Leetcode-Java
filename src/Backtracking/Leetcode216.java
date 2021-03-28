package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode216 {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n,k,1);
        return res;
    }

    private void backTracking(int sum, int k, int i){
        //剪枝
        if(sum<0) return;
        //定义终止条件
        if(path.size()==k){
            if(sum==0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int j = i; j < 10; j++) {
            path.add(j);
            sum -= j;
            backTracking(sum,k,j+1);
            sum += j;
            path.remove(path.size()-1);
        }

    }
}
