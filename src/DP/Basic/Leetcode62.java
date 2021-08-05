package DP.Basic;

/**
 * @author hbx
 * @date 2021-07-11 15:21
 */
public class Leetcode62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    continue;
                }
                else if(i==0&&j>0){
                    //如果是在第一行，只可能来自于左边一格
                    dp[i][j] = dp[i][j-1];
                }else if(j==0&&i>0){
                    //如果是在第一列，只可能来自于上面一格
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
//                if(i==0&&j>0){
//                        //如果是在第一行，只可能来自于左边一格
//                        dp[i][j] = dp[i][j-1];
//                        }else if(j==0&&i>0){
//                        //如果是在第一列，只可能来自于上面一格
//                        dp[i][j] = dp[i-1][j];
//                        }else{
//                        dp[i][j] = dp[i][j-1] + dp[i-1][j];
//                        }