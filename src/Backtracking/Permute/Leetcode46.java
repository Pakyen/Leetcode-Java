package Backtracking.Permute;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(0==nums.length){
            res.add(new ArrayList<>());
            return res;
        }
        boolean[] used = new boolean[nums.length];
        backTracking(nums,used);
        return res;
    }
    private void backTracking(int[] nums, boolean[] used){
        if(nums.length==path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backTracking(nums,used);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
