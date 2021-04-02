package Backtracking.Subset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode491 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;
    }
    private void backTracking(int[] nums, int startIndex){
        if(startIndex>=nums.length) return;
        //同层去重，分枝会重新定义自己的set
        //所以set定义在for循环前就实现了同层去重
        Set<Integer> set = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            if(!path.isEmpty() && nums[i] < path.get(path.size()-1)
                || set.contains(nums[i]) ){
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            if(path.size()>1) res.add(new ArrayList<>(path));
            backTracking(nums,i+1);
            path.remove(path.size()-1);
        }
    }

}
