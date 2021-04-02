package Backtracking.Subset;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backTracking(nums,0);
        return res;
    }

    private void backTracking(int[] nums, int startIndex){
        if(startIndex>=nums.length){
            return; //因为子集问题要收集所有结点，所以直接返回
        }
        for (int i = startIndex; i < nums.length ; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backTracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
