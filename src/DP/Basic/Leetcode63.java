package DP.Basic;

/**
 * @author hbx
 * @date 2021-07-11 15:56
 */
public class Leetcode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //注意，第一行和第一列也可能有障碍物，且有障碍物后，后面的位置都是0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //注意，左上角第一格也有可能有障碍物
                if(obstacleGrid[i][j]==1) {
                    dp[i][j]=0;
                    continue;
                }
                if(i==0&&j==0) dp[i][j] =1;
                else if(i==0) dp[i][j] = dp[i][j-1];
                else if(j==0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
