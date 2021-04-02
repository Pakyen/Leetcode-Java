package Backtracking.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] used = new boolean[nums.length];

        res.add(new ArrayList<>());
        Arrays.sort(nums);

        backTracking(nums,0,used);
        return res;
    }
    private void backTracking(int[] nums, int startIndex, boolean[] used){
        if(startIndex>=nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            used[i] = true;
            backTracking(nums,i+1,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

}
