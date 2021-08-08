package 笔试;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hbx
 * @date 2021-08-08 8:08 PM
 */

/*
遍历Ann，判断相邻两道题，是否合理，不合理就剔除
应该用回溯法
 */
public class 拼多多4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n ; i++) {
            a[i] = in.nextInt();
            used[i] = false;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backTracking(a,used,m,res,path);
        System.out.println(res.size());
    }
    private static void backTracking(int[] nums, boolean[] used, int m,List<List<Integer>> res, List<Integer> path ){
        if(nums.length==path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        //可以回过头从头取，所以不需要startIndex
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            if(!path.isEmpty() && nums[i] >= path.get(path.size()-1) - m ){
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums,used,m,res,path);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
