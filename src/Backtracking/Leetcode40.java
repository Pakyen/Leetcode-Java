package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTracking(candidates,target,0,used);
        return res;
    }

    private void backTracking(int[] candidates, int target, int startIndex, boolean[] used){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && (target-candidates[i]>=0); i++) {
            if(i>0 && candidates[i]==candidates[i-1] && !used[i-1]){
                continue;
            }
            target -= candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backTracking(candidates,target,i+1,used);
            path.remove(path.size()-1);
            target += candidates[i];
            used[i] = false;
        }
    }
}
