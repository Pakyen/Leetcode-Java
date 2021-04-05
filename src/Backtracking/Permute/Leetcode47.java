package Backtracking.Permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode47 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        //排序+used 去重
        Arrays.sort(nums);
        backTracking(nums,used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //同一层，有重复元素使用过，直接跳过
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            if(!used[i]){
                //同一树枝，没使用过的数字就可以添加
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums,used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
