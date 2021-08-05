package DP.Basic;

/**
 * @author hbx
 * @date 2021-07-11 16:32
 */
public class Leetcode343 {
    public int integerBreak(int n){
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j < i-1; j++) {
                dp[i] = Math.max(dp[i],Math.max( j*(i-j), j*dp[i-j] ));
            }
        }
        return dp[n];
    }
}
