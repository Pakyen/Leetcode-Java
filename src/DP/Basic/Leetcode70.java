package DP.Basic;

/**
 * @author hbx
 * @date 2021-07-11 14:37
 */
public class Leetcode70 {
    public int climbStairs(int n) {
        // fn = fn-1 + fn-2
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        //题目给定n是正整数 n>0
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
