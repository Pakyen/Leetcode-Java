package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);    //为了剪枝
        backTracking(candidates,target,0);
        return res;
    }
    private void backTracking(int[] candidates,int target,int startIndex){
        if(target<0) return;
        if(target==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝
        for (int i = startIndex; i < candidates.length && (target-candidates[i]>=0); i++) {
            path.add(candidates[i]);
            target -= candidates[i];
            backTracking(candidates,target,i);  //这里不需要i++了，且是填i而不是starIndex
            path.remove(path.size()-1);
            target += candidates[i];
        }
    }
}

